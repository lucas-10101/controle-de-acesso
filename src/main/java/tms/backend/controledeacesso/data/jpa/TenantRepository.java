package tms.backend.controledeacesso.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tms.backend.controledeacesso.data.entities.Tenant;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Integer> {

}
