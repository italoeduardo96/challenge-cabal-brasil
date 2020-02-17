package br.com.cabal.challengemerchantapi.service.impl;

import br.com.cabal.challengemerchantapi.api.dto.address.AddressRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.address.AddressResponseDto;
import br.com.cabal.challengemerchantapi.exception.RegisterNotFoundException;
import br.com.cabal.challengemerchantapi.mapper.AddressMapper;
import br.com.cabal.challengemerchantapi.model.AddressEntity;
import br.com.cabal.challengemerchantapi.repository.AddressRepository;
import br.com.cabal.challengemerchantapi.service.AddressService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public AddressResponseDto updateAddressById(Integer addressId, AddressRequestDto addressRequestDto) {

        AddressEntity addressEntity = addressRepository.findById(addressId)
                .map(k -> {

                    if (!StringUtils.isEmpty(addressRequestDto.getCdZipcode())) {
                        k.setCdZipcode(addressRequestDto.getCdZipcode());
                    }

                    if (!StringUtils.isEmpty(addressRequestDto.getCdCity())) {
                        k.setCdCity(addressRequestDto.getCdCity());
                    }

                    if (!StringUtils.isEmpty(addressRequestDto.getCdNeighborhood())) {
                        k.setCdNeighborhood(addressRequestDto.getCdNeighborhood());
                    }

                    if (!StringUtils.isEmpty(addressRequestDto.getCdUf())) {
                        k.setCdUf(addressRequestDto.getCdUf());
                    }

                    if (!StringUtils.isEmpty(addressRequestDto.getDsAddress())) {
                        k.setDsAddress(addressRequestDto.getDsAddress());
                    }

                    if (!StringUtils.isEmpty(addressRequestDto.getNuAddress())) {
                        k.setNuAddress(addressRequestDto.getNuAddress());
                    }

                    if (!StringUtils.isEmpty(addressRequestDto.getDsComplement())) {
                        k.setDsComplement(addressRequestDto.getDsComplement());
                    }

                    return k;
                }).orElseThrow(() -> new RegisterNotFoundException(AddressEntity.class, "id", addressId.toString()));

        return saveAndReturnDTO(addressEntity);
    }

    @Override
    public void deleteAddressById(Integer addressId) {
        addressRepository.findById(addressId).orElseThrow(() -> new RegisterNotFoundException(AddressEntity.class, "id", addressId.toString()));
        addressRepository.deleteById(addressId);
    }

    private AddressResponseDto saveAndReturnDTO(AddressEntity addressEntity) {
        AddressEntity address = addressRepository.save(addressEntity);
        return addressMapper.toResponseDTO(addressEntity);
    }
}
