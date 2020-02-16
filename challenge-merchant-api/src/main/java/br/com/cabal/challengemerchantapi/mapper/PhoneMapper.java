package br.com.cabal.challengemerchantapi.mapper;

import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantResponseDto;
import br.com.cabal.challengemerchantapi.api.dto.phone.PhoneResponseDto;
import br.com.cabal.challengemerchantapi.model.MerchantEntity;
import br.com.cabal.challengemerchantapi.model.PhoneEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PhoneMapper {

    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);

    PhoneResponseDto toResponseDto(PhoneEntity phoneEntity);

    List<PhoneResponseDto> toRequestDtoList(List<PhoneEntity> phones);

    PhoneEntity toEntity(PhoneResponseDto phoneResponseDto);
}
