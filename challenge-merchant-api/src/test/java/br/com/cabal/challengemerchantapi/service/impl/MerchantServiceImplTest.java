package br.com.cabal.challengemerchantapi.service.impl;

import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantResponseDto;
import br.com.cabal.challengemerchantapi.mapper.MerchantMapper;
import br.com.cabal.challengemerchantapi.model.MerchantEntity;
import br.com.cabal.challengemerchantapi.repository.MerchantRepository;
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
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MerchantServiceImplTest {

    @InjectMocks
    public MerchantServiceImpl merchantService;

    @Mock
    public MerchantRepository merchantRepository;

    @Mock
    public MerchantMapper merchantMapper;

    @Test
    public void getAllMerchants() {
        when(merchantRepository.findAll()).thenReturn(getEntities());
        when(merchantMapper.toResponseDtoList(anyList())).thenReturn(getResponseList());
        assertThat(merchantService.getAllMerchants()).isNotEmpty();
    }

    @Test
    public void getMerchantById() {
        when(merchantRepository.findById(1)).thenReturn(getEntities().stream().findFirst());
        when(merchantMapper.toResponseDto(any())).thenReturn(getResponse());

        assertThat(merchantService.getMerchantById(1)).isNotNull();
    }

    @Test
    public void getMerchantEntityById() {
        when(merchantRepository.findById(1))
                .thenReturn(getEntities().stream().findFirst());
        assertThat(merchantService.getMerchantEntityById(1)).isNotNull();
    }

    @Test
    public void saveMerchant() {
        this.merchantService.saveMerchant(any());
        verify(merchantRepository).save(any());
    }

    @Test
    public void deleteMerchantById() {
        when(merchantRepository.findById(1)).thenReturn(getEntities().stream().findFirst());
        merchantService.deleteMerchantById(1);
        verify(merchantRepository).deleteById(1);
    }

    @Test
    public void updateMerchantById() {
        Optional<MerchantEntity> optional = getEntities().stream().findFirst();
        when(merchantRepository.findById(1)).thenReturn(optional);
        merchantService.updateMerchantById(1, new MerchantRequestDto());

        verify(merchantRepository).save(optional.get());
    }

    private List<MerchantResponseDto> getResponseList(){
        List<MerchantResponseDto> dtos = new ArrayList<>();
        dtos.add(getResponse());
        return dtos;
    }

    private MerchantResponseDto getResponse(){
        MerchantResponseDto dto = new MerchantResponseDto();
        dto.setId(1);
        return dto;
    }

    private MerchantEntity getEntity(){
        MerchantEntity entity = new MerchantEntity();
        entity.setId(1);
        return entity;
    }

    private List<MerchantEntity> getEntities(){
        List<MerchantEntity> entities = new ArrayList<>();
        entities.add(getEntity());
        return entities;
    }
}
