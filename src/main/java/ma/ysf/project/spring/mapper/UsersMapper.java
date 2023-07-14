package ma.ysf.project.spring.mapper;

import ma.ysf.project.spring.Dto.RoleDto;
import ma.ysf.project.spring.Dto.UsersDto;
import ma.ysf.project.spring.model.Role;
import ma.ysf.project.spring.model.Users;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UsersMapper {

    @Autowired
    DozerBeanMapper mapper;

    public UsersDto usersToUsersDto(Users users){
        UsersDto usersDto = mapper.map(users,UsersDto.class);


        if(users.getRole() != null){
            usersDto.setRoleDto(mapper.map(users.getRole(), RoleDto.class));
        }
        return usersDto;
    }

    public List<UsersDto> usersToUsersDto(List<Users> usersList){
        List<UsersDto>  usersDtoList = new ArrayList<>();
        usersList.forEach(users -> {
            usersDtoList.add(usersToUsersDto(users));
        });
        return usersDtoList;
    }

    public Users usersDtoToUsers(UsersDto usersDto){
        Users users = mapper.map(usersDto, Users.class);

        if(usersDto.getRoleDto() != null){
            users.setRole(mapper.map(usersDto.getRoleDto(), Role.class));
        }
        return users;
    }

    public List<Users> usersDtoToUsers(List<UsersDto> usersDtoList){
        List<Users> usersList = new ArrayList<>();
        usersDtoList.forEach(usersDto -> {
            usersList.add(usersDtoToUsers(usersDto));
        });
        return  usersList;
    }


}
