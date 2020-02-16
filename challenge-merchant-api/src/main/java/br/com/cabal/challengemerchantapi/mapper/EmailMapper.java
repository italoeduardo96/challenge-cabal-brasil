package br.com.cabal.challengemerchantapi.mapper;

import br.com.cabal.challengemerchantapi.api.dto.email.EmailResponseDto;
import br.com.cabal.challengemerchantapi.model.EmailEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmailMapper {

    EmailMapper INSTANCE = Mappers.getMapper(EmailMapper.class);

    EmailResponseDto toResponseDto(EmailEntity emailEntity);

    List<EmailResponseDto> toRequestDtoList(List<EmailEntity> emails);

    EmailEntity toEntity(EmailResponseDto emailResponseDto);



}
