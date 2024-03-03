package tms.backend.controledeacesso.providers.identityprovider;

import java.net.URI;
import java.util.Objects;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import tms.backend.controledeacesso.data.models.TokenRequest;
import tms.backend.controledeacesso.data.models.TokenResponse;
import tms.backend.controledeacesso.providers.IdentityProvider;

@Component
public class KeycloakIdentityProvider implements IdentityProvider {

    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String issuerUri;

    @Value("${app.oauth2.client_id}")
    private String clientId;

    @Value("${app.oauth2.client_secret}")
    private String clientSecret;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public TokenResponse authenticate(TokenRequest tokenRequest) throws Exception {

        var useRefreshToken = tokenRequest.getRefreshToken() != null;

        MultiValueMap<String, String> payload = new LinkedMultiValueMap<>(useRefreshToken ? 3 : 5);
        payload.add(OAuth2Constants.CLIENT_ID, clientId);
        payload.add(OAuth2Constants.CLIENT_SECRET, clientSecret);
        payload.add(OAuth2Constants.GRANT_TYPE, useRefreshToken ? OAuth2Constants.REFRESH_TOKEN : OAuth2Constants.PASSWORD);

        if (useRefreshToken) {
            payload.add(OAuth2Constants.REFRESH_TOKEN, Objects.requireNonNull(tokenRequest.getRefreshToken()));
        } else {
            payload.add(OAuth2Constants.USERNAME, Objects.requireNonNull(tokenRequest.getUsername()));
            payload.add(OAuth2Constants.PASSWORD, Objects.requireNonNull(tokenRequest.getPassword()));
        }

        var uri = new URI(issuerUri + "/protocol/openid-connect/token");
        AccessTokenResponse accessTokenResponse = restTemplate.postForObject(uri, payload, AccessTokenResponse.class);

        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setAccessToken(accessTokenResponse.getToken());
        tokenResponse.setRefreshToken(accessTokenResponse.getRefreshToken());

        return tokenResponse;
    }

    protected String getRealmName() {
        var parts = issuerUri.split("/");
        return parts[parts.length - 1];
    }

    protected Keycloak getInstance() {
        return KeycloakBuilder.builder()
                .realm(getRealmName())
                .clientId(clientId)
                .clientSecret(clientSecret)
                .build();
    }
}
