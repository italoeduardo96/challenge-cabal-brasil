package br.com.cabal.challengemerchantapi.service;

import br.com.cabal.challengemerchantapi.api.dto.address.AddressRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.address.AddressResponseDto;
import br.com.cabal.challengemerchantapi.api.dto.email.EmailRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.email.EmailResponseDto;
import br.com.cabal.challengemerchantapi.api.dto.phone.PhoneRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.phone.PhoneResponseDto;

import java.util.List;

public interface MaintainMerchantDataService {

    AddressResponseDto getAddressMerchantById(Integer merchantId);
    List<PhoneResponseDto> getPhonesMerchantById(Integer merchantId);
    List<EmailResponseDto> getEmailsMerchantById(Integer merchantId);

    AddressResponseDto updateAddressMerchantById(Integer idMerchant, Integer idAddress, AddressRequestDto addressRequestDto);
    PhoneResponseDto updatePhonesMerchantById(Integer idMerchant, Integer idAddress, PhoneRequestDto phoneRequestDto);
    EmailResponseDto updateEmailMerchantById(Integer idMerchant, Integer idAddress, EmailRequestDto emailRequestDto);

    void deleteAddressMerchantById(Integer idMerchant, Integer idAddress);
    void deletePhoneMerchantById(Integer idMerchant, Integer idPhone);
    void deleteEmailMerchantById(Integer idMerchant, Integer idEMail);



}
