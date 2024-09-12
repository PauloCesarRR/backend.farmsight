package org.farmsight.app.controller;

import jakarta.validation.Valid;
import org.farmsight.app.domain.User;
import org.farmsight.app.dtos.AuthDTO;
import org.farmsight.app.dtos.LoginResponseDTO;
import org.farmsight.app.dtos.UserDTO;
import org.farmsight.app.infra.oauth.TokenService;
import org.farmsight.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService service;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserDTO data) throws Exception {
        if (this.service.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        this.service.create(data);

        return ResponseEntity.ok().build();
    }
}