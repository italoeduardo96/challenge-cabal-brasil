package br.com.cabal.challengemerchantapi.service.impl;

import br.com.cabal.challengemerchantapi.api.dto.phone.PhoneRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.phone.PhoneResponseDto;
import br.com.cabal.challengemerchantapi.exception.RegisterNotFoundException;
import br.com.cabal.challengemerchantapi.mapper.PhoneMapper;
import br.com.cabal.challengemerchantapi.model.PhoneEntity;
import br.com.cabal.challengemerchantapi.repository.PhoneRepository;
import br.com.cabal.challengemerchantapi.service.PhoneService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;
    private final PhoneMapper phoneMapper;

    public PhoneServiceImpl(PhoneRepository phoneRepository, PhoneMapper phoneMapper) {
        this.phoneRepository = phoneRepository;
        this.phoneMapper = phoneMapper;
    }


    @Override
    public PhoneResponseDto updatePhonesById(Integer phoneId, PhoneRequestDto phoneRequestDto) {

        PhoneEntity phoneEntity = phoneRepository.findById(phoneId).map(k -> {

            if(!StringUtils.isEmpty(phoneRequestDto.getNuDdd())){
                k.setNuDdd(phoneRequestDto.getNuDdd());
            }

            if(!StringUtils.isEmpty(phoneRequestDto.getNuPhone())){
                k.setNuPhone(phoneRequestDto.getNuPhone());
            }

            if(!StringUtils.isEmpty(phoneRequestDto.getTpPhone())){
                k.setTpPhone(phoneRequestDto.getTpPhone());
            }

            return k;
        }).orElseThrow(() -> new RegisterNotFoundException(PhoneEntity.class, "id", phoneId.toString()));

        return saveAndReturnDTO(phoneEntity);
    }

    private PhoneResponseDto saveAndReturnDTO(PhoneEntity phoneEntity) {
        PhoneEntity phone = phoneRepository.save(phoneEntity);
        return phoneMapper.toResponseDto(phone);
    }

}
