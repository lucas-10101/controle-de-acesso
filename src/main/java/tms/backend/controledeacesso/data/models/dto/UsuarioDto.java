package tms.backend.controledeacesso.data.models.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UsuarioDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "id")
    private Integer id;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "roles")
    private Collection<PermissaoDto> permissoes = new LinkedList<>();

    @JsonProperty(value = "groups")
    private Collection<GrupoDto> grupos = new LinkedList<>();
}
