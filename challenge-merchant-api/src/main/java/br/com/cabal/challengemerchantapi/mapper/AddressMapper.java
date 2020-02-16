package br.com.cabal.challengemerchantapi.mapper;

import br.com.cabal.challengemerchantapi.api.dto.address.AddressResponseDto;
import br.com.cabal.challengemerchantapi.api.dto.email.EmailResponseDto;
import br.com.cabal.challengemerchantapi.model.AddressEntity;
import br.com.cabal.challengemerchantapi.model.EmailEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressResponseDto toResponseDTO(AddressEntity addressEntity);

    List<AddressResponseDto> toRequestDtoList(List<AddressEntity> adresses);

    AddressEntity toEntity(AddressResponseDto addressResponseDto);

}
