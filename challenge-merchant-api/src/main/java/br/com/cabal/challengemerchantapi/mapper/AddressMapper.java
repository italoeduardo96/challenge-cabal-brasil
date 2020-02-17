package br.com.cabal.challengemerchantapi.mapper;

import br.com.cabal.challengemerchantapi.api.dto.address.AddressRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.address.AddressResponseDto;
import br.com.cabal.challengemerchantapi.model.AddressEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {
    AddressResponseDto toResponseDTO(AddressEntity addressEntity);
    List<AddressResponseDto> toResponseDtoList(List<AddressEntity> adresses);
    AddressEntity toEntity(AddressRequestDto addressRequestDto);
}
