package tms.backend.controledeacesso.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tms.backend.controledeacesso.data.entities.PermissaoGrupoUsuario;
import tms.backend.controledeacesso.data.entities.PermissaoGrupoUsuario.PermissaoGrupoUsuarioPk;

@Repository
public interface PermissaoGrupoUsuarioRepository extends JpaRepository<PermissaoGrupoUsuario, PermissaoGrupoUsuarioPk> {

}
