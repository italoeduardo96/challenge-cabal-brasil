package br.com.cabal.challengemerchantapi.repository;

import br.com.cabal.challengemerchantapi.model.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
}
