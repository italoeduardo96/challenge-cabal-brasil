package br.com.cabal.challengemerchantapi.repository;

import br.com.cabal.challengemerchantapi.model.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<EmailEntity, Integer > {
}
