package com.leandro.viagemais.dto;

import java.time.LocalDate;
import java.util.UUID;

public record TicketDTO(Double serviceFee,
        Double boardingFee,
        String airline,
        String flightType,
        Boolean roundTrip,
        LocalDate date,
        int quantity,
        Boolean promotion,
        String airlineCnpj,
        Double value,
        UUID destination_id) {
}
