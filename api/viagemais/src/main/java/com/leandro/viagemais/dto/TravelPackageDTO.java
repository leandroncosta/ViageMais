package com.leandro.viagemais.dto;

import java.util.UUID;

public record TravelPackageDTO(Boolean promotion, Double totalValue, UUID hotel_id, UUID ticket_id) {

}
