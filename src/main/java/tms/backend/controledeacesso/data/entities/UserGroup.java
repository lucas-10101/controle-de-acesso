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
@Table(name = "user_groups")
public class UserGroup {

    @EmbeddedId
    private UserGroupPk id;

    @Data
    @Embeddable
    public static class UserGroupPk implements Serializable {

        private static final long serialVersionUID = 1L;

        @ManyToOne(optional = false, fetch = FetchType.LAZY)
        @JoinColumn(name = "group_id", nullable = false)
        private Group group;

        @ManyToOne(optional = false, fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        private User user;
    }
}
