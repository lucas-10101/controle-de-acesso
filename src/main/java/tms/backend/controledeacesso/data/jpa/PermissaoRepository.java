package tms.backend.controledeacesso.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tms.backend.controledeacesso.data.entities.Permissao;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Integer> {

}
