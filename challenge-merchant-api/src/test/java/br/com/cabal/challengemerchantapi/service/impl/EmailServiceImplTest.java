package br.com.cabal.challengemerchantapi.service.impl;

import br.com.cabal.challengemerchantapi.api.dto.email.EmailRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.email.EmailResponseDto;
import br.com.cabal.challengemerchantapi.mapper.AddressMapper;
import br.com.cabal.challengemerchantapi.mapper.EmailMapper;
import br.com.cabal.challengemerchantapi.model.AddressEntity;
import br.com.cabal.challengemerchantapi.model.EmailEntity;
import br.com.cabal.challengemerchantapi.repository.EmailRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmailServiceImplTest {

    @InjectMocks
    private EmailServiceImpl emailService;

    @Mock
    private EmailRepository emailRepository;

    @Mock
    private EmailMapper emailMapper;

    @Test
    public void getEmailById() {
        when(emailRepository.findById(1)).thenReturn(getEmailEntity());
        when(this.emailMapper.toResponseDto(any())).thenReturn(getEmailResponseDto());

        assertThat(emailService.getEmailById(1)).isNotNull();
    }

    @Test
    public void updateEmailById() {
        Optional<EmailEntity> optional = getEmailEntity();
        when(this.emailRepository.findById(1)).thenReturn(optional);
        emailService.updateEmailById(1, new EmailRequestDto());

        verify(emailRepository).save(optional.get());
    }

    @Test
    public void deleteEmailById() {
        when(emailRepository.findById(1)).thenReturn(getEmailEntity());
        emailService.deleteEmailById(1);
        verify(emailRepository).deleteById(1);
    }

    private Optional<EmailEntity> getEmailEntity(){
        List<EmailEntity> emailEntities = new ArrayList<>();
        EmailEntity entity = new EmailEntity();
        entity.setId(1);
        emailEntities.add(entity);
        return emailEntities.stream().findAny();
    }

    private EmailResponseDto getEmailResponseDto(){
        EmailResponseDto emailResponseDto = new EmailResponseDto();
        emailResponseDto.setId(1);
        return emailResponseDto;
    }
}
