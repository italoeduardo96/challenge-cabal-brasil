package br.com.cabal.challengemerchantapi.repository;

import br.com.cabal.challengemerchantapi.model.MerchantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<MerchantEntity, Integer> {
}
