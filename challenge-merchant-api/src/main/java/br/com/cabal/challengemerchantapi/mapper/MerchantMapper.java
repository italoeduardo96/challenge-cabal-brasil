package br.com.cabal.challengemerchantapi.mapper;

import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantResponseDto;
import br.com.cabal.challengemerchantapi.model.MerchantEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MerchantMapper {

    MerchantMapper INSTANCE = Mappers.getMapper(MerchantMapper.class);

    MerchantResponseDto toResponseDto(MerchantEntity merchantEntity);

    List<MerchantResponseDto> toRequestDtoList(List<MerchantEntity> merchants);

    MerchantEntity toEntity(MerchantRequestDto merchantRequestDto);



}
