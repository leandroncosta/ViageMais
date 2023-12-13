package com.leandro.viagemais.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leandro.viagemais.entities.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
  UserDetails findByLogin(String login);

  @Transactional
  @Modifying
  @Query(nativeQuery = true, value = "INSERT INTO user_package (user_id, páckage_id) VALUES (:userId, :packageId)")
  void addUserPackage(@Param("userId") UUID userId, @Param("packageId") UUID packageId);

  @Transactional
  @Modifying
  @Query(nativeQuery = true, value = "INSERT INTO user_ticket (user_id, ticket_id) VALUES (:userId, :ticketId)")
  void addUserTicket(@Param("userId") UUID userId, @Param("ticketId") UUID ticketId);
}
