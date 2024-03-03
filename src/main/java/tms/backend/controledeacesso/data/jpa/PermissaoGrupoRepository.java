package tms.backend.controledeacesso.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tms.backend.controledeacesso.data.entities.PermissaoGrupo;
import tms.backend.controledeacesso.data.entities.PermissaoGrupo.PermissaoGrupoPk;

@Repository
public interface PermissaoGrupoRepository extends JpaRepository<PermissaoGrupo, PermissaoGrupoPk> {

}
