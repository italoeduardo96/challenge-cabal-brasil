package br.com.cabal.challengemerchantapi.mapper;

import br.com.cabal.challengemerchantapi.api.dto.email.EmailRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.email.EmailResponseDto;
import br.com.cabal.challengemerchantapi.model.EmailEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EmailMapper {
    EmailResponseDto toResponseDto(EmailEntity emailEntity);
    List<EmailResponseDto> toResponseDtoList(List<EmailEntity> emails);
    EmailEntity toEntity(EmailRequestDto emailRequestDto);
}
