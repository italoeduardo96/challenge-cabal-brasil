package br.com.cabal.challengemerchantapi.service.impl;

import br.com.cabal.challengemerchantapi.api.dto.address.AddressRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.address.AddressResponseDto;
import br.com.cabal.challengemerchantapi.api.dto.email.EmailRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.email.EmailResponseDto;
import br.com.cabal.challengemerchantapi.api.dto.phone.PhoneRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.phone.PhoneResponseDto;
import br.com.cabal.challengemerchantapi.mapper.AddressMapper;
import br.com.cabal.challengemerchantapi.mapper.EmailMapper;
import br.com.cabal.challengemerchantapi.mapper.PhoneMapper;
import br.com.cabal.challengemerchantapi.model.AddressEntity;
import br.com.cabal.challengemerchantapi.model.EmailEntity;
import br.com.cabal.challengemerchantapi.model.MerchantEntity;
import br.com.cabal.challengemerchantapi.model.PhoneEntity;
import br.com.cabal.challengemerchantapi.service.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintainMerchantServiceImpl implements MaintainMerchantDataService {

    private final AddressMapper addressMapper;
    private final PhoneMapper phoneMapper;
    private final EmailMapper emailMapper;

    private final AddressService addressService;
    private final MerchantService merchantService;
    private final PhoneService phoneService;
    private final EmailService emailService;

    public MaintainMerchantServiceImpl(AddressMapper addressMapper, PhoneMapper phoneMapper, EmailMapper emailMapper, MerchantService merchantService, AddressService addressService, EmailService emailService, PhoneService phoneService) {
        this.addressMapper = addressMapper;
        this.phoneMapper = phoneMapper;
        this.emailMapper = emailMapper;
        this.merchantService = merchantService;
        this.addressService = addressService;
        this.emailService = emailService;
        this.phoneService = phoneService;
    }

    @Override
    public AddressResponseDto getAddressMerchantById(Integer merchantId) {
        return addressMapper.toResponseDTO(merchantService.getMerchantEntityById(merchantId).getAddress());
    }

    @Override
    public List<PhoneResponseDto> getPhonesMerchantById(Integer merchantId) {
        return phoneMapper.toResponseDtoList(merchantService.getMerchantEntityById(merchantId).getPhones());
    }

    @Override
    public List<EmailResponseDto> getEmailsMerchantById(Integer merchantId) {
        return emailMapper.toResponseDtoList(merchantService.getMerchantEntityById(merchantId).getEmails());
    }

    @Override
    public AddressResponseDto updateAddressMerchantById(Integer idMerchant, Integer idAddress, AddressRequestDto addressRequestDto) {
        merchantService.getMerchantById(idMerchant);
        return addressService.updateAddressById(idAddress, addressRequestDto);
    }

    @Override
    public PhoneResponseDto updatePhonesMerchantById(Integer idMerchant, Integer idPhone, PhoneRequestDto phoneRequestDto) {
        merchantService.getMerchantById(idMerchant);
        return phoneService.updatePhonesById(idPhone, phoneRequestDto);
    }

    @Override
    public EmailResponseDto updateEmailMerchantById(Integer idMerchant, Integer idEmail, EmailRequestDto emailRequestDto) {
        merchantService.getMerchantById(idMerchant);
        return emailService.updateEmailById(idEmail, emailRequestDto);
    }

    @Override
    public void deleteAddressMerchantById(Integer idMerchant, Integer idAddress) {
        AddressEntity address = merchantService.getMerchantEntityById(idMerchant).getAddress();
        addressService.deleteAddressById(address.getId());
    }

    @Override
    public void deletePhoneMerchantById(Integer idMerchant, Integer idPhone) {
        MerchantEntity merchant = merchantService.getMerchantEntityById(idMerchant);
        PhoneEntity phoneAux = null;

        List<PhoneEntity> phones = merchant.getPhones();
        for (PhoneEntity phone: phones){
            if(phone.getId().equals(idPhone) ){
                phoneAux = phone;
            }
        }

        if(phoneAux != null) {
            phones.remove(phoneAux);
        }

        merchantService.saveMerchantByEntity(merchant);
    }

    @Override
    public void deleteEmailMerchantById(Integer idMerchant, Integer idEmail) {
        MerchantEntity merchantEntity = merchantService.getMerchantEntityById(idMerchant);
        EmailEntity emailAux = null;

        List<EmailEntity> emails = merchantEntity.getEmails();
        for(EmailEntity email: emails) {
            if(email.getId().equals(idEmail) ){
                emailAux = email;
            }
        }

        if(emailAux != null){
            emails.remove(emailAux);
        }
        merchantService.saveMerchantByEntity(merchantEntity);
    }
}
