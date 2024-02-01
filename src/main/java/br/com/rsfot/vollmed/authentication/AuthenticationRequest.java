package br.com.rsfot.vollmed.authentication;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationRequest(
        @NotBlank
        String login,
        @NotBlank
        String password) {
}
