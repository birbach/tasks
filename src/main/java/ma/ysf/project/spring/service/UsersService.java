package ma.ysf.project.spring.service;

import ma.ysf.project.spring.Dto.AuthenticationRequest;
import ma.ysf.project.spring.model.Users;
import ma.ysf.project.spring.Dto.AuthenticationResponse;

public interface UsersService {

//    public UsersDto registerUsers(UsersDto usersDto);

//    public UsersDto findByUsername(String username);

    public AuthenticationResponse registerUsers(Users usersDto);

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}
