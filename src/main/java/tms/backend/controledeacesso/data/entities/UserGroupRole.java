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
import tms.backend.controledeacesso.data.entities.GroupRole.GroupRolePk;

@Data
@Entity
@Table(name = "user_group_roles")
public class UserGroupRole {

    @EmbeddedId
    private UserGroupRolePk id;

    @Data
    @Embeddable
    public static class UserGroupRolePk implements Serializable {

        private static final long serialVersionUID = 1L;

        @Embedded
        private GroupRolePk groupRoleId;

        @ManyToOne(optional = false, fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        private User user;
    }
}
