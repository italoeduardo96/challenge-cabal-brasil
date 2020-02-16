package br.com.cabal.challengemerchantapi.service.impl;

import br.com.cabal.challengemerchantapi.api.dto.address.AddressResponseDto;
import br.com.cabal.challengemerchantapi.api.dto.email.EmailResponseDto;
import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantResponseDto;
import br.com.cabal.challengemerchantapi.api.dto.phone.PhoneResponseDto;
import br.com.cabal.challengemerchantapi.exception.RegisterNotFoundException;
import br.com.cabal.challengemerchantapi.mapper.AddressMapper;
import br.com.cabal.challengemerchantapi.mapper.EmailMapper;
import br.com.cabal.challengemerchantapi.mapper.MerchantMapper;
import br.com.cabal.challengemerchantapi.mapper.PhoneMapper;
import br.com.cabal.challengemerchantapi.model.MerchantEntity;
import br.com.cabal.challengemerchantapi.repository.MerchantRepository;
import br.com.cabal.challengemerchantapi.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantService {

    private final MerchantRepository merchantRepository;

    @Autowired
    public MerchantServiceImpl(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    @Override
    public List<MerchantResponseDto> getAllMerchants() {
        return MerchantMapper.INSTANCE.toRequestDtoList(merchantRepository.findAll());
    }

    @Override
    public MerchantResponseDto getMerchant(Integer merchantId) {
        return merchantRepository.findById(merchantId).map( k -> MerchantMapper.INSTANCE.toResponseDto(k))
                .orElseThrow( () -> new RegisterNotFoundException(MerchantEntity.class, "merchantId", merchantId.toString()));
    }

    @Override
    public AddressResponseDto getAddressMerchant(Integer merchantId) {
        return merchantRepository.findById(merchantId).map(
                k -> AddressMapper.INSTANCE.toResponseDTO(k.getAddress()))
                .orElseThrow( () -> new RegisterNotFoundException(MerchantEntity.class, "id", merchantId.toString()));
    }

    @Override
    public List<PhoneResponseDto> getPhonesMerchant(Integer merchantId) {
        return merchantRepository.findById(merchantId).map(
                k -> PhoneMapper.INSTANCE.toRequestDtoList(k.getPhones()))
                .orElseThrow( () -> new RegisterNotFoundException(MerchantEntity.class, "id", merchantId.toString()));
    }

    @Override
    public List<EmailResponseDto> getEmailsMerchant(Integer merchantId) {
        return merchantRepository.findById(merchantId).map(
                k -> EmailMapper.INSTANCE.toRequestDtoList(k.getEmails()))
                .orElseThrow( () -> new RegisterNotFoundException(MerchantEntity.class, "id", merchantId.toString()));
    }

    @Override
    public MerchantResponseDto saveMerchant(MerchantRequestDto merchantRequestDto) {
        return saveAndReturnDTO(MerchantMapper.INSTANCE.toEntity(merchantRequestDto));
    }

    @Override
    public void deleteMerchant(Integer id) {
        merchantRepository.findById(id).orElseThrow(() -> new RegisterNotFoundException(MerchantEntity.class, "id", id.toString()));
        merchantRepository.deleteById(id);
    }

    @Override
    public MerchantResponseDto updateMerchant(Integer id, MerchantRequestDto merchantRequestDto) {

        MerchantEntity merchantEntity = merchantRepository.findById(id).map(k -> {

            if(!StringUtils.isEmpty(merchantRequestDto.getNuDocument())){
                k.setNuDocument(merchantRequestDto.getNuDocument());
            }

            if(!StringUtils.isEmpty(merchantRequestDto.getNmMerchant())){
                k.setNmMerchant(merchantRequestDto.getNmMerchant());
            }

            return k;
        }).orElseThrow(() -> new RegisterNotFoundException(MerchantEntity.class, "id", id.toString()));

        return saveAndReturnDTO(merchantEntity);
    }

    private MerchantResponseDto saveAndReturnDTO(MerchantEntity merchantEntity) {
        MerchantEntity merchant = merchantRepository.save(merchantEntity);
        return MerchantMapper.INSTANCE.toResponseDto(merchant);
    }

}
