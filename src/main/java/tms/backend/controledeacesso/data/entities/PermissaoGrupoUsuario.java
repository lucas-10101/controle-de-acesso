package tms.backend.controledeacesso.data.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import tms.backend.controledeacesso.data.entities.PermissaoGrupo.PermissaoGrupoPk;

@Data
@Entity
@Table(name = "permissao_grupo_usuario")
public class PermissaoGrupoUsuario {

    @EmbeddedId
    private PermissaoGrupoUsuarioPk id;

    @Embeddable
    public class PermissaoGrupoUsuarioPk implements Serializable {

        private static final long serialVersionUID = 1L;

        @Embedded
        private PermissaoGrupoPk permissaoGrupoPk;

        @ManyToOne(optional = false, fetch = FetchType.LAZY)
        @JoinColumn(name = "id_usuario", nullable = false)
        private Usuario usuario;

    }
}
