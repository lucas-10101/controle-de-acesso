package tms.backend.controledeacesso.data.jpa;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tms.backend.controledeacesso.data.entities.PermissaoUsuario;
import tms.backend.controledeacesso.data.entities.PermissaoUsuario.PermissaoUsuarioPk;
import tms.backend.controledeacesso.data.entities.Usuario;

@Repository
public interface PermissaoUsuarioRepository extends JpaRepository<PermissaoUsuario, PermissaoUsuarioPk> {

    Collection<PermissaoUsuario> findByIdUsuario(Usuario usuario);
}
