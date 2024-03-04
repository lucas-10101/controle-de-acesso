package tms.backend.controledeacesso.data.models.dto;

import java.io.Serializable;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GrupoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "name")
    private String nome;

    @JsonProperty(value = "roles")
    private Collection<PermissaoDto> permissoes;


}
