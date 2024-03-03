package tms.backend.controledeacesso.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tms.backend.controledeacesso.data.entities.PermissaoUsuario;
import tms.backend.controledeacesso.data.entities.PermissaoUsuario.PermissaoUsuarioPk;

@Repository
public interface PermissaoUsuarioRepository extends JpaRepository<PermissaoUsuario, PermissaoUsuarioPk> {

}
