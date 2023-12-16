package com.leandro.viagemais.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import com.leandro.viagemais.entities.BuyTicket;

public interface BuyTicketRepository extends JpaRepository<BuyTicket, UUID> {

  // @Transactional
  // @Modifying
  // @Query(nativeQuery = true, value = "INSERT INTO buy_ticket (user_id,
  // ticket_id) VALUES (:userId, :ticketId)")
  // void saveTicket(@Param("userId") UUID userId, @Param("ticketId") UUID
  // ticketId);

  @Query(nativeQuery = true, value = "SELECT * FROM user_ticket JOIN user ON user.id = user_ticket.user_id JOIN ticket ON ticket.id = user_ticket.ticket_id")
  List<Object> findAllTicket();

}
