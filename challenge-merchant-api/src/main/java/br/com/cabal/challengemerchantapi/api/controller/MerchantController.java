package br.com.cabal.challengemerchantapi.api.controller;

import br.com.cabal.challengemerchantapi.api.dto.address.AddressResponseDto;
import br.com.cabal.challengemerchantapi.api.dto.email.EmailResponseDto;
import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantResponseDto;
import br.com.cabal.challengemerchantapi.api.dto.phone.PhoneResponseDto;
import br.com.cabal.challengemerchantapi.exception.RegisterNotFoundException;
import br.com.cabal.challengemerchantapi.service.MerchantService;
import br.com.cabal.challengemerchantapi.validation.ValidationSequenceCreate;
import br.com.cabal.challengemerchantapi.validation.ValidationSequenceUpdate;
import io.swagger.annotations.*;
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

    @Autowired
    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
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
        return merchantService.getMerchant(id);
    }

    @ApiOperation(value="Find address merchant",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code=200, message="Address found", response = AddressResponseDto.class),
            @ApiResponse(code=404, message="Merchant not found", response = RegisterNotFoundException.class)})
    @GetMapping("/{id}/adresses")
    @ResponseStatus(HttpStatus.OK)
    public AddressResponseDto getAddressMerchant(@PathVariable Integer id){
        return merchantService.getAddressMerchant(id);
    }

    @ApiOperation(value="Find phones merchant",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code=200, message="Phones found", response = PhoneResponseDto[].class),
            @ApiResponse(code=404, message="Merchant not found", response = RegisterNotFoundException.class)})
    @GetMapping("/{id}/phones")
    @ResponseStatus(HttpStatus.OK)
    public List<PhoneResponseDto> getPhonesMerchant(@PathVariable Integer id){
        return merchantService.getPhonesMerchant(id);
    }

    @ApiOperation(value="Find emails merchant",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code=200, message="Emails found", response = EmailResponseDto[].class),
            @ApiResponse(code=404, message="Merchant not found", response = RegisterNotFoundException.class)})
    @GetMapping("/{id}/emails")
    @ResponseStatus(HttpStatus.OK)
    public List<EmailResponseDto> getEmailsMerchant(@PathVariable Integer id){
        return merchantService.getEmailsMerchant(id);
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
    public MerchantResponseDto saveMerchant(@PathVariable Integer id, @Validated(ValidationSequenceUpdate.class) @RequestBody MerchantRequestDto merchantRequestDto){
        return merchantService.updateMerchant(id, merchantRequestDto);
    }

    @ApiOperation(value = "Delete merchant by ID",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code=204,message="Merchant deleted",response = MerchantResponseDto.class),
            @ApiResponse(code=404,message="Merchant not found",response = RegisterNotFoundException.class)})
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMerchant(@PathVariable Integer id){
        merchantService.deleteMerchant(id);
    }

}
