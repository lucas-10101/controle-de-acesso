package tms.backend.controledeacesso.data.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PermissaoDto {

    @JsonProperty(value = "id")
    private Integer id;

    @JsonProperty(value = "name")
    private String nome;
}
