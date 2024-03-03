package tms.backend.controledeacesso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tms.backend.controledeacesso.data.models.TokenRequest;
import tms.backend.controledeacesso.data.models.TokenResponse;
import tms.backend.controledeacesso.providers.IdentityProvider;

@RestController
@RequestMapping(path = "/auth", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    @Autowired
    private IdentityProvider identityProvider;

    @PostMapping(path = "/token")
    public ResponseEntity<TokenResponse> authenticateWithCredentials(@RequestBody TokenRequest tokenRequest) throws Exception {
        return ResponseEntity.ok(identityProvider.authenticate(tokenRequest));
    }
}
