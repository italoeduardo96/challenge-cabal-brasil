package br.com.cabal.challengemerchantapi.service.impl;

import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantResponseDto;
import br.com.cabal.challengemerchantapi.exception.RegisterNotFoundException;
import br.com.cabal.challengemerchantapi.mapper.MerchantMapper;
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
    public MerchantResponseDto getMerchantById(Integer id) {
        return merchantRepository.findById(id).map( k -> MerchantMapper.INSTANCE.toResponseDto(k))
                .orElseThrow( () -> new RegisterNotFoundException(MerchantEntity.class, "id", id.toString()));
    }

    @Override
    public MerchantResponseDto saveMerchant(MerchantRequestDto merchantRequestDto) {
        return saveAndReturnDTO(MerchantMapper.INSTANCE.toEntity(merchantRequestDto));
    }

    @Override
    public void deleteMerchantById(Integer id) {
        merchantRepository.findById(id).orElseThrow(() -> new RegisterNotFoundException(MerchantEntity.class, "id", id.toString()));
        merchantRepository.deleteById(id);
    }

    @Override
    public MerchantResponseDto updateMerchantByDto(Integer id, MerchantRequestDto merchantRequestDto) {

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
