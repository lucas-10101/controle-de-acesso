package tms.backend.controledeacesso.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tms.backend.controledeacesso.data.entities.GrupoUsuario;
import tms.backend.controledeacesso.data.entities.GrupoUsuario.GrupoUsuarioPk;

@Repository
public interface GrupoUsuarioRepository extends JpaRepository<GrupoUsuario, GrupoUsuarioPk> {

}
