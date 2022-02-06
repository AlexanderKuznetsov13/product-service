package ru.alex.kuznetsov.project.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.alex.kuznetsov.project.product.config.jwt.JwtProvider;
import ru.alex.kuznetsov.project.product.dto.AuthRequestDto;
import ru.alex.kuznetsov.project.product.dto.AuthResponseDto;
import ru.alex.kuznetsov.project.product.entity.UserEntity;
import ru.alex.kuznetsov.project.product.service.IUserService;


@RestController
public class AuthController {
    @Autowired
    private IUserService userService;
    @Autowired
    private JwtProvider jwtProvider;

//    @PostMapping("/register")
//    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
//        UserEntity u = new UserEntity();
//        u.setPassword(registrationRequest.getPassword());
//        u.setLogin(registrationRequest.getLogin());
//        userService.saveUser(u);
//        return "OK";
//    }

    @PostMapping("/auth")
    public AuthResponseDto auth(@RequestBody AuthRequestDto request) {
        UserEntity userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(userEntity.getLogin());
        return new AuthResponseDto(token);
    }
}
