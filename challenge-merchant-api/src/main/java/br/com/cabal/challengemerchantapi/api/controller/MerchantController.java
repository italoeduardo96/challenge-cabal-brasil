package br.com.cabal.challengemerchantapi.api.controller;

import br.com.cabal.challengemerchantapi.api.dto.address.AddressRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.address.AddressResponseDto;
import br.com.cabal.challengemerchantapi.api.dto.email.EmailRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.email.EmailResponseDto;
import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantResponseDto;
import br.com.cabal.challengemerchantapi.api.dto.phone.PhoneRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.phone.PhoneResponseDto;
import br.com.cabal.challengemerchantapi.exception.RegisterNotFoundException;
import br.com.cabal.challengemerchantapi.service.MaintainMerchantDataService;
import br.com.cabal.challengemerchantapi.service.MerchantService;
import br.com.cabal.challengemerchantapi.validation.ValidationSequenceCreate;
import br.com.cabal.challengemerchantapi.validation.ValidationSequenceUpdate;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/merchants", produces = {MediaType.APPLICATION_JSON_VALUE})
public class MerchantController {

    private final MerchantService merchantService;
    private final MaintainMerchantDataService maintainMerchantDataService;

    @Autowired
    public MerchantController(MerchantService merchantService, MaintainMerchantDataService maintainMerchantDataService) {
        this.merchantService = merchantService;
        this.maintainMerchantDataService = maintainMerchantDataService;
    }

    @ApiOperation(value = "Find all merchants", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(@ApiResponse(code=200, message="List of merchants", response = MerchantResponseDto[].class))
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MerchantResponseDto> getAllMerchants(){
        return merchantService.getAllMerchants();
    }

    @ApiOperation(value = "Find merchant by ID", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code=200, message="Merchant found", response = MerchantResponseDto.class),
            @ApiResponse(code=404, message="Merchant not found", response = RegisterNotFoundException.class)})
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MerchantResponseDto getMerchantById(@PathVariable Integer id){
        return merchantService.getMerchantById(id);
    }

    @ApiOperation(value = "Create merchant", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(@ApiResponse(code=201, message="Merchant created", response = MerchantResponseDto.class))
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MerchantResponseDto saveMerchant(@Validated(ValidationSequenceCreate.class) @RequestBody MerchantRequestDto merchantRequestDto){
        return merchantService.saveMerchant(merchantRequestDto);
    }

    @ApiOperation(value = "Update merchant by ID",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code=200,message="Merchant updated",response = MerchantResponseDto.class),
            @ApiResponse(code=404,message="Merchant not found",response = RegisterNotFoundException.class)})
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MerchantResponseDto updateMerchant(@PathVariable Integer id, @Validated(ValidationSequenceUpdate.class) @RequestBody MerchantRequestDto merchantRequestDto){
        return merchantService.updateMerchantById(id, merchantRequestDto);
    }

    @ApiOperation(value = "Delete merchant by ID",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code=204,message="Merchant deleted"),
            @ApiResponse(code=404,message="Merchant not found",response = RegisterNotFoundException.class)})
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMerchant(@PathVariable Integer id){
        merchantService.deleteMerchantById(id);
    }


    //#################### Merchant Address Endpoint #################################
    //################################################################################

    @ApiOperation(value="Find address merchant",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code=200, message="Address found", response = AddressResponseDto.class),
            @ApiResponse(code=404, message="Merchant not found", response = RegisterNotFoundException.class)})
    @GetMapping("/{id}/adresses")
    @ResponseStatus(HttpStatus.OK)
    public AddressResponseDto getAddressMerchant(@PathVariable Integer id){
        return maintainMerchantDataService.getAddressMerchantById(id);
    }

    @ApiOperation(value = "Update address merchant by ID",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code=200,message="Merchant address updated",response = AddressResponseDto.class),
            @ApiResponse(code=404,message="Merchant not found",response = RegisterNotFoundException.class)})
    @PutMapping("/{idMerchant}/adresses/{idAddress}")
    @ResponseStatus(HttpStatus.OK)
    public AddressResponseDto updatePhoneMerchant(@PathVariable("idMerchant") Integer idMerchant,
                                              @PathVariable("idAddress") Integer idAddress,
                                              @Validated(ValidationSequenceUpdate.class) @RequestBody AddressRequestDto addressRequestDto){
        return maintainMerchantDataService.updateAddressMerchantById(idMerchant, idAddress, addressRequestDto);
    }

    @ApiOperation(value = "Delete address merchant by IDs",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code=204,message="Merchant address deleted"),
            @ApiResponse(code=404,message="Merchant not found",response = RegisterNotFoundException.class)})
    @DeleteMapping("/{idMerchant}/adresses/{idAddress}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAddressMerchant(@PathVariable("idMerchant") Integer idMerchant, @PathVariable("idAddress") Integer idAddress){
        maintainMerchantDataService.deleteAddressMerchantById(idMerchant, idAddress);
    }

    //#################### Merchant Phones Endpoint ##################################
    //################################################################################

    @ApiOperation(value="Find phones merchant",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code=200, message="Phones found", response = PhoneResponseDto[].class),
            @ApiResponse(code=404, message="Merchant not found", response = RegisterNotFoundException.class)})
    @GetMapping("/{id}/phones")
    @ResponseStatus(HttpStatus.OK)
    public List<PhoneResponseDto> getPhonesMerchant(@PathVariable Integer id){
        return maintainMerchantDataService.getPhonesMerchantById(id);
    }

    @ApiOperation(value = "Update phone merchant by ID",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code=200,message="Merchant phone updated",response = PhoneResponseDto.class),
            @ApiResponse(code=404,message="Merchant not found",response = RegisterNotFoundException.class)})
    @PutMapping("/{idMerchant}/phones/{idPhone}")
    @ResponseStatus(HttpStatus.OK)
    public PhoneResponseDto updateAddressMerchant(@PathVariable("idMerchant") Integer idMerchant,
                                                  @PathVariable("idPhone") Integer idPhone,
                                                  @Validated(ValidationSequenceUpdate.class) @RequestBody PhoneRequestDto phoneRequestDto){
        return maintainMerchantDataService.updatePhonesMerchantById(idMerchant, idPhone, phoneRequestDto);
    }

    @ApiOperation(value = "Delete phone merchant by IDs",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code=204,message="Merchant phone deleted"),
            @ApiResponse(code=404,message="Merchant not found",response = RegisterNotFoundException.class)})
    @DeleteMapping("/{idMerchant}/phones/{idPhone}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePhoneMerchant(@PathVariable("idMerchant") Integer idMerchant, @PathVariable("idPhone") Integer idPhone){
        maintainMerchantDataService.deletePhoneMerchantById(idMerchant, idPhone);
    }

    //#################### Merchant Emails Endpoint #################################
    //################################################################################


    @ApiOperation(value="Find emails merchant",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code=200, message="Emails found", response = EmailResponseDto[].class),
            @ApiResponse(code=404, message="Merchant not found", response = RegisterNotFoundException.class)})
    @GetMapping("/{id}/emails")
    @ResponseStatus(HttpStatus.OK)
    public List<EmailResponseDto> getEmailsMerchant(@PathVariable Integer id){
        return maintainMerchantDataService.getEmailsMerchantById(id);
    }

    @ApiOperation(value = "Update email merchant by ID",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code=200,message="Merchant email updated",response = EmailResponseDto.class),
            @ApiResponse(code=404,message="Merchant not found",response = RegisterNotFoundException.class)})
    @PutMapping("/{idMerchant}/emails/{idEmail}")
    @ResponseStatus(HttpStatus.OK)
    public EmailResponseDto updateEmailsMerchant(@PathVariable("idMerchant") Integer idMerchant,
                                                  @PathVariable("idEmail") Integer idEmail,
                                                  @Validated(ValidationSequenceUpdate.class) @RequestBody EmailRequestDto emailRequestDto){
        return maintainMerchantDataService.updateEmailMerchantById(idMerchant, idEmail, emailRequestDto);
    }

    @ApiOperation(value = "Delete email merchant by IDs",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code=204,message="Merchant email deleted"),
            @ApiResponse(code=404,message="Merchant not found",response = RegisterNotFoundException.class)})
    @DeleteMapping("/{idMerchant}/emails/{idEmail}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmailMerchant(@PathVariable("idMerchant") Integer idMerchant, @PathVariable("idEmail") Integer idEmail){
        maintainMerchantDataService.deleteEmailMerchantById(idMerchant, idEmail);
    }
}
