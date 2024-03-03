package tms.backend.controledeacesso.data.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "grupo_usuario")
public class GrupoUsuario {

    @EmbeddedId
    private GrupoUsuarioPk id;

    @Data
    @Embeddable
    public static class GrupoUsuarioPk implements Serializable {

        private static final long serialVersionUID = 1L;

        @ManyToOne(optional = false, fetch = FetchType.LAZY)
        @JoinColumn(name = "id_grupo", nullable = false)
        private Grupo grupo;

        @ManyToOne(optional = false, fetch = FetchType.LAZY)
        @JoinColumn(name = "id_usuario", nullable = false)
        private Usuario usuario;
    }
}
