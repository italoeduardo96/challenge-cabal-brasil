package br.com.cabal.challengemerchantapi.service;

import br.com.cabal.challengemerchantapi.api.dto.address.AddressResponseDto;
import br.com.cabal.challengemerchantapi.api.dto.email.EmailResponseDto;
import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantResponseDto;
import br.com.cabal.challengemerchantapi.api.dto.phone.PhoneResponseDto;

import java.util.List;

public interface MerchantService {

    List<MerchantResponseDto> getAllMerchants();
    MerchantResponseDto getMerchant(Integer merchantId);
    MerchantResponseDto saveMerchant(MerchantRequestDto merchantRequest);
    MerchantResponseDto updateMerchant(Integer merchantId, MerchantRequestDto merchantRequest);
    void deleteMerchant(Integer merchantId);

    AddressResponseDto getAddressMerchant(Integer merchantId);
    List<PhoneResponseDto> getPhonesMerchant(Integer merchantId);
    List<EmailResponseDto> getEmailsMerchant(Integer merchantId);

}
