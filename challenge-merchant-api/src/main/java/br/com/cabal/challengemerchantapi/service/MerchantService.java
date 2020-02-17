package br.com.cabal.challengemerchantapi.service;

import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantResponseDto;
import br.com.cabal.challengemerchantapi.model.MerchantEntity;

import java.util.List;

public interface MerchantService {

    List<MerchantResponseDto> getAllMerchants();
    MerchantResponseDto getMerchantById(Integer merchantId);
    MerchantResponseDto saveMerchant(MerchantRequestDto merchantRequest);
    MerchantResponseDto updateMerchantById(Integer merchantId, MerchantRequestDto merchantRequest);
    void deleteMerchantById(Integer merchantId);

    MerchantEntity getMerchantEntityById(Integer merchantId);
    MerchantEntity saveMerchantByEntity(MerchantEntity merchantEntity);


}
