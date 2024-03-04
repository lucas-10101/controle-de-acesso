package tms.backend.controledeacesso.data.jpa;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tms.backend.controledeacesso.data.entities.PermissaoGrupoUsuario;
import tms.backend.controledeacesso.data.entities.PermissaoGrupoUsuario.PermissaoGrupoUsuarioPk;
import tms.backend.controledeacesso.data.entities.Usuario;

@Repository
public interface PermissaoGrupoUsuarioRepository extends JpaRepository<PermissaoGrupoUsuario, PermissaoGrupoUsuarioPk> {

    Collection<PermissaoGrupoUsuario> findByIdUsuario(Usuario usuario);
}
