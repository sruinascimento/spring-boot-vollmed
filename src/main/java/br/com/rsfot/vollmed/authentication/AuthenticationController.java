package br.com.rsfot.vollmed.authentication;

import br.com.rsfot.vollmed.infra.security.TokenService;
import br.com.rsfot.vollmed.user.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    ResponseEntity<String> singIn(@Valid @RequestBody AuthenticationRequest authenticationRequest) {
        var credentials = new UsernamePasswordAuthenticationToken(authenticationRequest.login(), authenticationRequest.password());
        Authentication authentication = authenticationManager.authenticate(credentials);
        String token = tokenService.generateToken((User) authentication.getPrincipal());
        return ResponseEntity.ok("{\"token\": %s}".formatted(token));
    }
}
