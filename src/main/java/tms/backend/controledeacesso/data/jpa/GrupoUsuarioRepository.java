package tms.backend.controledeacesso.data.jpa;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tms.backend.controledeacesso.data.entities.GrupoUsuario;
import tms.backend.controledeacesso.data.entities.GrupoUsuario.GrupoUsuarioPk;
import tms.backend.controledeacesso.data.entities.Usuario;

@Repository
public interface GrupoUsuarioRepository extends JpaRepository<GrupoUsuario, GrupoUsuarioPk> {

    public Collection<GrupoUsuario> findByIdUsuario(Usuario usuario);
}
