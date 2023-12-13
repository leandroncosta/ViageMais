package com.leandro.viagemais.dto;

import java.util.UUID;

public record TravelPackageDTO(Boolean promotion, Double totalValue, UUID hotelId, UUID ticketId) {

}
