package tms.backend.controledeacesso.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tms.backend.controledeacesso.data.entities.Locatario;

@Repository
public interface LocatarioRepository extends JpaRepository<Locatario, Integer> {

}
