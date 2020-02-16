package br.com.cabal.challengemerchantapi.api.controller;

import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantRequestDto;
import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantResponseDto;
import br.com.cabal.challengemerchantapi.exception.RegisterNotFoundException;
import br.com.cabal.challengemerchantapi.service.MerchantService;
import br.com.cabal.challengemerchantapi.validation.UpdateMerchantValidationInterface;
import br.com.cabal.challengemerchantapi.validation.ValidationSequenceCreate;
import br.com.cabal.challengemerchantapi.validation.ValidationSequenceUpdate;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/merchants", produces = {MediaType.APPLICATION_JSON_VALUE})
public class MerchantController {

    private final MerchantService merchantService;

    @Autowired
    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @ApiOperation(
            value = "Find all merchants",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(
            @ApiResponse(
                    code=200,
                    message="List of merchants",
                    response = MerchantResponseDto[].class))
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MerchantResponseDto> getAllMerchants(){
        return merchantService.getAllMerchants();
    }

    @ApiOperation(
            value = "Find merchant by ID",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(
                    code=200,
                    message="Merchant found",
                    response = MerchantResponseDto.class),
            @ApiResponse(
                    code=404,
                    message="Merchant not found",
                    response = RegisterNotFoundException.class)})
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MerchantResponseDto getMerchantById(@PathVariable Integer id){
        return merchantService.getMerchantById(id);
    }

    @ApiOperation(
            value = "Create merchant",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(
            @ApiResponse(
                    code=201,
                    message="Merchant created",
                    response = MerchantResponseDto.class))
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MerchantResponseDto saveMerchant(@Validated(ValidationSequenceCreate.class) @RequestBody MerchantRequestDto merchantRequestDto){
        return merchantService.saveMerchant(merchantRequestDto);
    }

    @ApiOperation(
            value = "Update merchant by ID",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(
                    code=200,
                    message="Merchant updated",
                    response = MerchantResponseDto.class),
            @ApiResponse(
                    code=404,
                    message="Merchant not found",
                    response = RegisterNotFoundException.class)})
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MerchantResponseDto saveMerchant(@PathVariable Integer id, @Validated(ValidationSequenceUpdate.class) @RequestBody MerchantRequestDto merchantRequestDto){
        return merchantService.updateMerchantByDto(id, merchantRequestDto);
    }

    @ApiOperation(
            value = "Delete merchant by ID",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(
                    code=204,
                    message="Merchant deleted",
                    response = MerchantResponseDto.class),
            @ApiResponse(
                    code=404,
                    message="Merchant not found",
                    response = RegisterNotFoundException.class)})
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMerchant(@PathVariable Integer id){
        merchantService.deleteMerchantById(id);
    }

}
