package br.com.cabal.challengemerchantapi.service.impl;

import br.com.cabal.challengemerchantapi.api.dto.phone.PhoneRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.phone.PhoneResponseDto;
import br.com.cabal.challengemerchantapi.mapper.PhoneMapper;
import br.com.cabal.challengemerchantapi.model.PhoneEntity;
import br.com.cabal.challengemerchantapi.repository.PhoneRepository;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PhoneServiceImplTest {

    @InjectMocks
    private PhoneServiceImpl phoneService;

    @Mock
    private PhoneRepository phoneRepository;

    @Mock
    private PhoneMapper phoneMapper;


    @Test
    public void updatePhonesById() {
        Optional<PhoneEntity> optional = getPhoneEntity();
        when(phoneRepository.findById(1)).thenReturn(optional);
        phoneService.updatePhonesById(1, new PhoneRequestDto());

        verify(phoneRepository).save(optional.get());
    }

    private Optional<PhoneEntity> getPhoneEntity(){
        List<PhoneEntity> phoneEntities = new ArrayList<>();
        PhoneEntity entity = new PhoneEntity();
        entity.setId(1);
        phoneEntities.add(entity);
        return phoneEntities.stream().findFirst();
    }

    private PhoneResponseDto getPhoneResponseDto(){
        PhoneResponseDto dto = new PhoneResponseDto();
        dto.setId(1);
        return dto;
    }
}
