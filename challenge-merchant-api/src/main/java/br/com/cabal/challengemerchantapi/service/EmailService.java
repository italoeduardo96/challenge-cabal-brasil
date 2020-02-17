package br.com.cabal.challengemerchantapi.service;

import br.com.cabal.challengemerchantapi.api.dto.email.EmailRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.email.EmailResponseDto;

public interface EmailService {
    
    EmailResponseDto getEmailById(Integer emailId);
    EmailResponseDto updateEmailById(Integer emailId, EmailRequestDto emailRequestDto);
    void deleteEmailById(Integer emailId);
}
