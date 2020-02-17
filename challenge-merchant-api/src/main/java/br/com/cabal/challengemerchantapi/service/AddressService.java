package br.com.cabal.challengemerchantapi.service;

import br.com.cabal.challengemerchantapi.api.dto.address.AddressRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.address.AddressResponseDto;

public interface AddressService {

    AddressResponseDto getAddressById(Integer addressId);
    AddressResponseDto updateAddressById(Integer addressId, AddressRequestDto addressRequestDto);
    void deleteAddressById(Integer addressId);
}
