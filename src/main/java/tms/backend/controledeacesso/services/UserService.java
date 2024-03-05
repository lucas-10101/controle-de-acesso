package tms.backend.controledeacesso.services;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tms.backend.controledeacesso.data.entities.User;
import tms.backend.controledeacesso.data.entities.UserGroup;
import tms.backend.controledeacesso.data.entities.UserGroupRole;
import tms.backend.controledeacesso.data.entities.UserRole;
import tms.backend.controledeacesso.data.jpa.GroupRepository;
import tms.backend.controledeacesso.data.jpa.RoleRepository;
import tms.backend.controledeacesso.data.jpa.UserGroupRepository;
import tms.backend.controledeacesso.data.jpa.UserGroupRoleRepository;
import tms.backend.controledeacesso.data.jpa.UserRepository;
import tms.backend.controledeacesso.data.jpa.UserRoleRepository;
import tms.backend.controledeacesso.data.models.dto.GrupoDto;
import tms.backend.controledeacesso.data.models.dto.PermissaoDto;
import tms.backend.controledeacesso.data.models.dto.UsuarioDto;
import tms.backend.controledeacesso.data.models.exceptions.ResourceNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository usuarioRepository;

    @Autowired
    private UserGroupRepository grupoUsuarioRepository;

    @Autowired
    private GroupRepository grupoRepository;

    @Autowired
    private RoleRepository permissaoRepository;

    @Autowired
    private UserRoleRepository permissaoUsuarioRepository;

    @Autowired
    private UserGroupRoleRepository permissaoGrupoUsuarioRepository;

    @Transactional(readOnly = true)
    public UsuarioDto getUser(Integer id) {

        User user = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(User.class, id));

        UsuarioDto userDto = new UsuarioDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());

        Collection<UserGroup> groups = grupoUsuarioRepository.findByIdUser(user);
        Collection<UserRole> roles = permissaoUsuarioRepository.findByIdUser(user);
        Collection<UserGroupRole> groupRoles = permissaoGrupoUsuarioRepository.findByIdUser(user);

        // Lazy load cache
        permissaoRepository.findAll();
        var groupIds = groups.stream().map(userGroups -> userGroups.getId().getGroup().getId()).collect(Collectors.toList());
        grupoRepository.findAllById(groupIds);

        roles.stream().map(userRole -> userRole.getId().getRole()).forEach(role -> {
            PermissaoDto dto = new PermissaoDto();
            dto.setId(role.getId());
            dto.setNome(role.getName());

            userDto.getPermissoes().add(dto);
        });

        groups.stream().map(userGroup -> userGroup.getId().getGroup()).forEach(group -> {

            GrupoDto dto = new GrupoDto();
            dto.setId(group.getId());
            dto.setNome(group.getName());

            var groupRoleList = groupRoles.stream().map(roleByGroup -> roleByGroup.getId().getGroupRoleId())
                    .filter(groupRole -> groupRole.getGroup().getId() == group.getId()).map(role -> {

                        PermissaoDto roleDto = new PermissaoDto();
                        roleDto.setId(role.getRole().getId());
                        roleDto.setNome(role.getRole().getName());

                        return roleDto;
                    }).collect(Collectors.toList());

            dto.setPermissoes(groupRoleList);

            userDto.getGrupos().add(dto);
        });

        return userDto;
    }

}
