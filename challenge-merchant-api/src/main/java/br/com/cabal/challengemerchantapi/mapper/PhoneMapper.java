package br.com.cabal.challengemerchantapi.mapper;

import br.com.cabal.challengemerchantapi.api.dto.phone.PhoneRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.phone.PhoneResponseDto;
import br.com.cabal.challengemerchantapi.model.PhoneEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PhoneMapper {
    PhoneResponseDto toResponseDto(PhoneEntity phoneEntity);
    List<PhoneResponseDto> toResponseDtoList(List<PhoneEntity> phones);
    PhoneEntity toEntity(PhoneRequestDto phoneRequestDto);
}
