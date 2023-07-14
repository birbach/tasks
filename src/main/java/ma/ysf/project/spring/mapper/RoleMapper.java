package ma.ysf.project.spring.mapper;

import ma.ysf.project.spring.Dto.RoleDto;
import ma.ysf.project.spring.model.Role;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleMapper {
    @Autowired
    DozerBeanMapper mapper;

    public RoleDto roleToRoleDto(Role role){
        RoleDto roleDto = mapper.map(role,RoleDto.class);
        return roleDto;
    }
    public List<RoleDto> roleToRoleDto(List<Role> roleList){
        List<RoleDto> dtos = new ArrayList<>();
        roleList.forEach(role -> {
            dtos.add(roleToRoleDto(role));
        });
        return dtos;
    }

    public Role roleDtoToRole(RoleDto roleDto){
        Role role = mapper.map(roleDto,Role.class);
        return role;
    }

    public List<Role> roleDtoToRole(List<RoleDto> roleDtoList){
        List<Role> dtos = new ArrayList<>();
        roleDtoList.forEach(role -> {
            dtos.add(roleDtoToRole(role));
        });
        return dtos;
    }
}
