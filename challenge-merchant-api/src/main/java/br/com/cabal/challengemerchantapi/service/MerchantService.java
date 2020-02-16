package br.com.cabal.challengemerchantapi.service;

import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantResponseDto;

import java.util.List;

public interface MerchantService {

    List<MerchantResponseDto> getAllMerchants();
    MerchantResponseDto saveMerchant(MerchantRequestDto merchantRequestDto);
    void deleteMerchantById(Integer id);
    MerchantResponseDto getMerchantById(Integer id);
    MerchantResponseDto updateMerchantByDto(Integer id, MerchantRequestDto vendorDTO);

}
