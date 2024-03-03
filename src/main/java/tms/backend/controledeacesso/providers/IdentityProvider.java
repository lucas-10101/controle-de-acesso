package tms.backend.controledeacesso.providers;

import tms.backend.controledeacesso.data.models.TokenRequest;
import tms.backend.controledeacesso.data.models.TokenResponse;

public interface IdentityProvider {

    public TokenResponse authenticate(TokenRequest tokenRequest) throws Exception;
}
