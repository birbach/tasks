package ma.ysf.project.spring.service.Impl;

import ma.ysf.project.spring.Dto.AuthenticationRequest;
import ma.ysf.project.spring.mapper.UsersMapper;
import ma.ysf.project.spring.model.Role;
import ma.ysf.project.spring.model.Users;
import ma.ysf.project.spring.repository.UsersRepository;
import ma.ysf.project.spring.Dto.AuthenticationResponse;
import ma.ysf.project.spring.security.utils.JwtUtils;
import ma.ysf.project.spring.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService, UserDetailsService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UsersMapper usersMapper;
    @Autowired
     JwtUtils jwtUtils;

    @Autowired
    AuthenticationManager authenticationManager;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }

//    @Override
//    public UsersDto registerUsers(UsersDto usersDto) {
//        usersDto.setPassword(passwordEncoder().encode(usersDto.getPassword()));
//        return usersMapper.usersToUsersDto(usersRepository.save(usersMapper.usersDtoToUsers(usersDto)));
//
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      return null;
    }
    @Override
    public AuthenticationResponse registerUsers(Users usersDto){
        var user = Users.builder()
                .prenom(usersDto.getPrenom())
                .nom(usersDto.getNom())
                .username(usersDto.getUsername())
                .email(usersDto.getEmail())
                .role(usersDto.getRole())
                .password(passwordEncoder().encode(usersDto.getPassword()))
                .build();
        usersRepository.save(user);
        var jwtToken= jwtUtils.generateToken(usersDto);
        var jwtRefreshToken= jwtUtils.generateRefreshToken(usersDto);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .username(user.getUsername())
                .role(user.getRole().getRoleName())
                .refreshToken(jwtRefreshToken)
                .build();
    }
    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        var user = usersRepository.findByUsername(authenticationRequest.getUsername()).orElseThrow();
        var jwtToken= jwtUtils.generateToken(user);
        var jwtRefreshToken= jwtUtils.generateRefreshToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .username(user.getUsername())
                .role(user.getRole().getRoleName())
                .refreshToken(jwtRefreshToken)
                .build();
    }

//    @Override
//    public Users findByUsername(String username) {
//        Optional<Users> users = usersRepository.findByUsername(username);
//
//        return users;
//    }
}
