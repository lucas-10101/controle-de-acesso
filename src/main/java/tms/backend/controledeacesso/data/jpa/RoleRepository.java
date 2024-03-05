package tms.backend.controledeacesso.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tms.backend.controledeacesso.data.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
