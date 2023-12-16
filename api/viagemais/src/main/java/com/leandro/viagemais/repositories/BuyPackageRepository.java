package com.leandro.viagemais.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leandro.viagemais.entities.BuyPackage;

public interface BuyPackageRepository extends JpaRepository<BuyPackage, UUID> {
  // @Transactional
  // @Modifying
  // @Query(nativeQuery = true, value = "INSERT INTO buy_package (user_id,
  // páckage_id) VALUES (:userId, :packageId)")
  // void savePackage(@Param("userId") UUID userId, @Param("packageId") UUID
  // packageId);

}
