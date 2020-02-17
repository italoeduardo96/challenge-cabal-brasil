package br.com.cabal.challengemerchantapi.mapper;

import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantResponseDto;
import br.com.cabal.challengemerchantapi.model.MerchantEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MerchantMapper {
    MerchantResponseDto toResponseDto(MerchantEntity merchantEntity);
    List<MerchantResponseDto> toResponseDtoList(List<MerchantEntity> merchants);
    MerchantEntity toEntity(MerchantRequestDto merchantRequestDto);
}
