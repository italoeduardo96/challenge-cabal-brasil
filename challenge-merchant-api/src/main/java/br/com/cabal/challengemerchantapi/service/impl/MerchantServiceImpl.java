package br.com.cabal.challengemerchantapi.service.impl;

import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantResponseDto;
import br.com.cabal.challengemerchantapi.exception.RegisterNotFoundException;
import br.com.cabal.challengemerchantapi.mapper.AddressMapper;
import br.com.cabal.challengemerchantapi.mapper.EmailMapper;
import br.com.cabal.challengemerchantapi.mapper.MerchantMapper;
import br.com.cabal.challengemerchantapi.mapper.PhoneMapper;
import br.com.cabal.challengemerchantapi.model.MerchantEntity;
import br.com.cabal.challengemerchantapi.repository.MerchantRepository;
import br.com.cabal.challengemerchantapi.service.MerchantService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantService {

    private final MerchantMapper merchantMapper;
    private final MerchantRepository merchantRepository;

    public MerchantServiceImpl(MerchantMapper merchantMapper, MerchantRepository merchantRepository) {
        this.merchantMapper = merchantMapper;
        this.merchantRepository = merchantRepository;
    }

    @Override
    public List<MerchantResponseDto> getAllMerchants() {
        return merchantMapper.toResponseDtoList(merchantRepository.findAll());
    }

    @Override
    public MerchantResponseDto getMerchantById(Integer merchantId) {
        return merchantRepository.findById(merchantId)
                .map( k -> merchantMapper.toResponseDto(k))
                .orElseThrow( () -> new RegisterNotFoundException(MerchantEntity.class, "id", merchantId.toString()));
    }

    public MerchantEntity getMerchantEntityById(Integer merchantId) {
        return merchantRepository.findById(merchantId)
                .orElseThrow( () -> new RegisterNotFoundException(MerchantEntity.class, "id", merchantId.toString()));
    }

    @Override
    public MerchantResponseDto saveMerchant(MerchantRequestDto merchantRequestDto) {
        return saveAndReturnDTO(merchantMapper.toEntity(merchantRequestDto));
    }

    @Override
    public void deleteMerchantById(Integer id) {
        merchantRepository.findById(id).orElseThrow(() -> new RegisterNotFoundException(MerchantEntity.class, "id", id.toString()));
        merchantRepository.deleteById(id);
    }

    @Override
    public MerchantResponseDto updateMerchantById(Integer id, MerchantRequestDto merchantRequestDto) {

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
        return merchantMapper.toResponseDto(merchant);
    }

    @Override
    public MerchantEntity saveMerchantByEntity(MerchantEntity merchantEntity) {
        return merchantRepository.save(merchantEntity);
    }
}
