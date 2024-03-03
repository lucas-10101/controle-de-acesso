package tms.backend.controledeacesso.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tms.backend.controledeacesso.data.entities.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {

}
