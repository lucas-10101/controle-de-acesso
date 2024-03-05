package tms.backend.controledeacesso.data.jpa;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tms.backend.controledeacesso.data.entities.UserGroup;
import tms.backend.controledeacesso.data.entities.UserGroup.UserGroupPk;
import tms.backend.controledeacesso.data.entities.User;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, UserGroupPk> {

    public Collection<UserGroup> findByIdUser(User user);
}
