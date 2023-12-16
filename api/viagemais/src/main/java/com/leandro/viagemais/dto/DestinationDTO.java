package com.leandro.viagemais.dto;

import jakarta.validation.constraints.NotBlank;

public record DestinationDTO(@NotBlank String city, String state, String imageUrl) {

}
