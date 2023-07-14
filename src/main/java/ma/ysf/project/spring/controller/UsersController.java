package ma.ysf.project.spring.controller;

import ma.ysf.project.spring.Dto.AuthenticationRequest;
import ma.ysf.project.spring.model.Users;
import ma.ysf.project.spring.Dto.AuthenticationResponse;
import ma.ysf.project.spring.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis/users/")
public class UsersController {

    @Autowired
    UsersService usersService;

    @PostMapping(value = "register")
    public ResponseEntity<AuthenticationResponse> registerUsers(@RequestBody Users usersDto){
     return ResponseEntity.ok(usersService.registerUsers(usersDto));
    }

    @PostMapping(value = "auth")
    public ResponseEntity<AuthenticationResponse> authenticateUers(@RequestBody AuthenticationRequest authenticationRequest){
        return ResponseEntity.ok(usersService.authenticate(authenticationRequest));
    }
}
