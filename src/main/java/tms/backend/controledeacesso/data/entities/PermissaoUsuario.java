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
@Table(name = "permissao_usuario")
public class PermissaoUsuario {

    @EmbeddedId
    private PermissaoUsuarioPk id;

    @Data
    @Embeddable
    public static class PermissaoUsuarioPk implements Serializable {

        private static final long serialVersionUID = 1L;

        @ManyToOne(optional = false, fetch = FetchType.LAZY)
        @JoinColumn(name = "id_permissao", nullable = false)
        private Permissao permissao;

        @ManyToOne(optional = false, fetch = FetchType.LAZY)
        @JoinColumn(name = "id_usuario", nullable = false)
        private Usuario usuario;
    }
}
