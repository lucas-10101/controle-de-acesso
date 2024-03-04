package tms.backend.controledeacesso.services;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tms.backend.controledeacesso.data.entities.GrupoUsuario;
import tms.backend.controledeacesso.data.entities.PermissaoGrupoUsuario;
import tms.backend.controledeacesso.data.entities.PermissaoUsuario;
import tms.backend.controledeacesso.data.entities.Usuario;
import tms.backend.controledeacesso.data.jpa.GrupoRepository;
import tms.backend.controledeacesso.data.jpa.GrupoUsuarioRepository;
import tms.backend.controledeacesso.data.jpa.PermissaoGrupoUsuarioRepository;
import tms.backend.controledeacesso.data.jpa.PermissaoRepository;
import tms.backend.controledeacesso.data.jpa.PermissaoUsuarioRepository;
import tms.backend.controledeacesso.data.jpa.UsuarioRepository;
import tms.backend.controledeacesso.data.models.dto.GrupoDto;
import tms.backend.controledeacesso.data.models.dto.PermissaoDto;
import tms.backend.controledeacesso.data.models.dto.UsuarioDto;
import tms.backend.controledeacesso.data.models.exceptions.ResourceNotFoundException;

@Service
public class UserService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private GrupoUsuarioRepository grupoUsuarioRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private PermissaoRepository permissaoRepository;

    @Autowired
    private PermissaoUsuarioRepository permissaoUsuarioRepository;

    @Autowired
    private PermissaoGrupoUsuarioRepository permissaoGrupoUsuarioRepository;

    @Transactional(readOnly = true)
    public UsuarioDto getUser(Integer id) {

        Usuario user = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Usuario.class, id));

        UsuarioDto userDto = new UsuarioDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());

        Collection<GrupoUsuario> groups = grupoUsuarioRepository.findByIdUsuario(user);
        Collection<PermissaoUsuario> roles = permissaoUsuarioRepository.findByIdUsuario(user);
        Collection<PermissaoGrupoUsuario> groupRoles = permissaoGrupoUsuarioRepository.findByIdUsuario(user);

        // Lazy load cache
        permissaoRepository.findAll();
        var groupIds = groups.stream().map(userGroups -> userGroups.getId().getGrupo().getId()).collect(Collectors.toList());
        grupoRepository.findAllById(groupIds);

        roles.stream().map(userRole -> userRole.getId().getPermissao()).forEach(role -> {
            PermissaoDto dto = new PermissaoDto();
            dto.setId(role.getId());
            dto.setNome(role.getNome());

            userDto.getPermissoes().add(dto);
        });

        groups.stream().map(userGroup -> userGroup.getId().getGrupo()).forEach(group -> {

            GrupoDto dto = new GrupoDto();
            dto.setId(group.getId());
            dto.setNome(group.getNome());

            var groupRoleList = groupRoles.stream().map(roleByGroup -> roleByGroup.getId().getPermissaoGrupoPk())
                    .filter(groupRole -> groupRole.getGrupo().getId() == group.getId()).map(role -> {

                        PermissaoDto roleDto = new PermissaoDto();
                        roleDto.setId(role.getPermissao().getId());
                        roleDto.setNome(role.getPermissao().getNome());

                        return roleDto;
                    }).collect(Collectors.toList());

            dto.setPermissoes(groupRoleList);

            userDto.getGrupos().add(dto);
        });

        return userDto;
    }

}
