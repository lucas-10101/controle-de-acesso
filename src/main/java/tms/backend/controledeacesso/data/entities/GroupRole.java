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
@Table(name = "group_roles")
public class GroupRole {

    @EmbeddedId
    private GroupRolePk id;

    @Data
    @Embeddable
    public static class GroupRolePk implements Serializable {

        private static final long serialVersionUID = 1L;

        @ManyToOne(optional = false, fetch = FetchType.LAZY)
        @JoinColumn(name = "role_id", nullable = false)
        private Role role;

        @ManyToOne(optional = false, fetch = FetchType.LAZY)
        @JoinColumn(name = "group_id", nullable = false)
        private Group group;
    }
}
