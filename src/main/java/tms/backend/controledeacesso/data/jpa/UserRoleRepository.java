package tms.backend.controledeacesso.data.jpa;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tms.backend.controledeacesso.data.entities.UserRole;
import tms.backend.controledeacesso.data.entities.UserRole.UserRolePk;
import tms.backend.controledeacesso.data.entities.User;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRolePk> {

    Collection<UserRole> findByIdUser(User user);
}
