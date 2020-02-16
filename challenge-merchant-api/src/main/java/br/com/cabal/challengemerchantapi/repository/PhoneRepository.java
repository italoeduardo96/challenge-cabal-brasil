package br.com.cabal.challengemerchantapi.repository;

import br.com.cabal.challengemerchantapi.model.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<PhoneEntity, Integer> {
}
