package com.leandro.viagemais.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.leandro.viagemais.dto.BuyPackageDTO;
import com.leandro.viagemais.entities.BuyPackage;

import com.leandro.viagemais.repositories.BuyPackageRepository;

import com.leandro.viagemais.repositories.TravelPackageRepository;
import com.leandro.viagemais.repositories.UserRepository;
import com.leandro.viagemais.servicesImpl.ServiceImplGeneric;

@Service
public class BuyPackageService extends ServiceImplGeneric<BuyPackage, UUID, BuyPackageRepository> {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private TravelPackageRepository travelPackageRepository;

  public BuyPackageService(@Qualifier("buyPackageRepository") BuyPackageRepository repository) {
    super(repository);

  }

  public void saveBuyPackage(BuyPackageDTO data) {
    var user = this.userRepository.findById(data.user_id())
        .orElseThrow(() -> new RuntimeException("ID: " + data.user_id() + " not found"));
    var package1 = this.travelPackageRepository.findById(data.package_id())
        .orElseThrow(() -> new RuntimeException("ID: " + data.package_id() + " not found"));

    if (user != null && package1 != null) {

      var buyPackage = new BuyPackage(data);

      // user.getPackages().add(package1);
      // package1.getUsers().add(user);

      buyPackage.setTravelPackage(package1);
      buyPackage.setUser(user);

      // this.userRepository.save(user);
      // this.travelPackageRepository.save(package1);

      this.repository.save(buyPackage);

    }
  }
}
