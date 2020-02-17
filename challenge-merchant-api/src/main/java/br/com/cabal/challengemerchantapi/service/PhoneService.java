package br.com.cabal.challengemerchantapi.service;

import br.com.cabal.challengemerchantapi.api.dto.phone.PhoneRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.phone.PhoneResponseDto;

public interface PhoneService {
    
    PhoneResponseDto updatePhonesById(Integer phoneId, PhoneRequestDto phoneRequestDto);
}
