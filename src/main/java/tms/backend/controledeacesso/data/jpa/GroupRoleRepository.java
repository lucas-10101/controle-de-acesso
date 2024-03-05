package tms.backend.controledeacesso.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tms.backend.controledeacesso.data.entities.GroupRole;
import tms.backend.controledeacesso.data.entities.GroupRole.GroupRolePk;

@Repository
public interface GroupRoleRepository extends JpaRepository<GroupRole, GroupRolePk> {

}
