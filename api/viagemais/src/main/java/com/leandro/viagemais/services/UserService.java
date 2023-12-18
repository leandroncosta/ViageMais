package com.leandro.viagemais.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.leandro.viagemais.entities.user.User;
import com.leandro.viagemais.repositories.UserRepository;
import com.leandro.viagemais.servicesImpl.ServiceImplGeneric;

@Service
public class UserService extends ServiceImplGeneric<User, UUID, UserRepository> {

  public UserService(@Qualifier("userRepository") UserRepository repository) {
    super(repository);
  }

  public UserDetails findByLogin(String login) {
    var user = this.repository.findByLogin(login);

    return user;
  }

  public UserDetails getUserInfo() {
    // Obtém a autenticação do contexto de segurança
    var authentication = SecurityContextHolder.getContext().getAuthentication();

    // Verifica se o usuário está autenticado
    if (authentication.isAuthenticated() && authentication.getPrincipal() instanceof UserDetails) {
      // Extrai os detalhes do usuário a partir do principal
      UserDetails userDetails = (UserDetails) authentication.getPrincipal();
      return userDetails;
    }
    return null;
  }
}
