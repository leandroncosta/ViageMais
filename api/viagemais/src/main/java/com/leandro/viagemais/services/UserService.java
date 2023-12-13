package com.leandro.viagemais.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.leandro.viagemais.dto.UserTicketDTO;
import com.leandro.viagemais.entities.user.User;
import com.leandro.viagemais.repositories.UserRepository;
import com.leandro.viagemais.servicesImpl.ServiceImplGeneric;

@Service
public class UserService extends ServiceImplGeneric<User, UUID, UserRepository> {

  public UserService(@Qualifier("userRepository") UserRepository repository) {
    super(repository);

  }

  public void addUserTicket(UserTicketDTO data) {
    this.repository.addUserTicket(data.userId(), data.ticketId());

  }

}
