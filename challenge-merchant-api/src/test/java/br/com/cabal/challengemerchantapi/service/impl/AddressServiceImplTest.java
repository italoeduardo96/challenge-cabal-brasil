package br.com.cabal.challengemerchantapi.service.impl;


import br.com.cabal.challengemerchantapi.api.dto.address.AddressRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.address.AddressResponseDto;
import br.com.cabal.challengemerchantapi.mapper.AddressMapper;
import br.com.cabal.challengemerchantapi.model.AddressEntity;
import br.com.cabal.challengemerchantapi.repository.AddressRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AddressServiceImplTest {

    @InjectMocks
    private AddressServiceImpl addressService;

    @Mock
    private AddressRepository addressRepository;
    @Mock
    private AddressMapper addressMapper;

    @Test
    public void updateAddressById() {
        Optional<AddressEntity> optional = getAddressEntity();
        when(addressRepository.findById(1)).thenReturn(optional);
        addressService.updateAddressById(1, new AddressRequestDto());

        verify(addressRepository).save(optional.get());
    }

    @Test
    public void deleteAddressById() {
        when(addressRepository.findById(1)).thenReturn(getAddressEntity());
        addressService.deleteAddressById(1);
        verify(addressRepository).deleteById(1);
    }

    private Optional<AddressEntity> getAddressEntity(){
        List<AddressEntity> addressEntities = new ArrayList<>();
        AddressEntity entity = new AddressEntity();
        entity.setId(1);
        addressEntities.add(entity);
        return addressEntities.stream().findAny();
    }

    private AddressResponseDto getAddressResponseDto(){
        AddressResponseDto dto = new AddressResponseDto();
        dto.setId(1);
        return dto;
    }

}
