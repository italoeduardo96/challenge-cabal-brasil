package br.com.cabal.challengemerchantapi.service.impl;

import br.com.cabal.challengemerchantapi.api.dto.email.EmailRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.email.EmailResponseDto;
import br.com.cabal.challengemerchantapi.exception.RegisterNotFoundException;
import br.com.cabal.challengemerchantapi.mapper.EmailMapper;
import br.com.cabal.challengemerchantapi.model.EmailEntity;
import br.com.cabal.challengemerchantapi.repository.EmailRepository;
import br.com.cabal.challengemerchantapi.service.EmailService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class EmailServiceImpl implements EmailService {

    private final EmailRepository emailRepository;
    private final EmailMapper emailMapper;

    public EmailServiceImpl(EmailRepository emailRepository, EmailMapper emailMapper) {
        this.emailRepository = emailRepository;
        this.emailMapper = emailMapper;
    }

    @Override
    public EmailResponseDto getEmailById(Integer emailId) {
        return emailRepository.findById(emailId)
                .map( k -> emailMapper.toResponseDto(k))
                .orElseThrow( () -> new RegisterNotFoundException(EmailEntity.class, "id", emailId.toString()));
    }

    @Override
    public EmailResponseDto updateEmailById(Integer emailId, EmailRequestDto emailRequestDto) {

        EmailEntity emailEntity = emailRepository.findById(emailId).map(k -> {

            if(!StringUtils.isEmpty(emailRequestDto.getDsEmail())){
                k.setDsEmail(emailRequestDto.getDsEmail());
            }

            return k;
        }).orElseThrow(() -> new RegisterNotFoundException(EmailEntity.class, "id", emailId.toString()));

        return saveAndReturnDTO(emailEntity);
    }

    @Override
    public void deleteEmailById(Integer emailId) {
        emailRepository.findById(emailId).orElseThrow(() -> new RegisterNotFoundException(EmailEntity.class, "id", emailId.toString()));
        emailRepository.deleteById(emailId);
    }

    private EmailResponseDto saveAndReturnDTO(EmailEntity emailEntity) {
        EmailEntity email = emailRepository.save(emailEntity);
        return emailMapper.toResponseDto(email);
    }

}
