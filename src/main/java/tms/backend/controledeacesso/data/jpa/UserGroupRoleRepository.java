package tms.backend.controledeacesso.data.jpa;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tms.backend.controledeacesso.data.entities.UserGroupRole;
import tms.backend.controledeacesso.data.entities.UserGroupRole.UserGroupRolePk;
import tms.backend.controledeacesso.data.entities.User;

@Repository
public interface UserGroupRoleRepository extends JpaRepository<UserGroupRole, UserGroupRolePk> {

    Collection<UserGroupRole> findByIdUser(User user);
}
