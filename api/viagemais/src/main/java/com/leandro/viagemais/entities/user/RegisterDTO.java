package com.leandro.viagemais.entities.user;

import jakarta.validation.constraints.NotBlank;

public record RegisterDTO(@NotBlank String login, @NotBlank String password, UserRole role) {

}
