package br.com.cabal.challengemerchantapi.api.controller;

import br.com.cabal.challengemerchantapi.api.dto.merchant.MerchantResponseDto;
import br.com.cabal.challengemerchantapi.exception.RegisterNotFoundException;
import br.com.cabal.challengemerchantapi.mapper.MerchantMapper;
import br.com.cabal.challengemerchantapi.service.MaintainMerchantDataService;
import br.com.cabal.challengemerchantapi.service.MerchantService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MerchantController.class)
public class MerchantControllerTest {

    @Autowired private MockMvc mockMvc;
    @MockBean private MerchantService merchantService;
    @MockBean private MaintainMerchantDataService maintainMerchantDataService;
    @MockBean private MerchantMapper merchantMapper;

    @Test
    public void getAllMerchantsTest() throws Exception {
        when(merchantService.getAllMerchants()).thenReturn(new ArrayList<>());
        when(merchantMapper.toResponseDtoList(anyList())).thenReturn(new ArrayList<>());
        this.mockMvc.perform(get("/api/v1/merchants")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void getMerchantByIdTest() throws Exception {
        when(merchantService.getMerchantById(1)).thenReturn(new MerchantResponseDto());
        when(merchantMapper.toResponseDto(any())).thenReturn(new MerchantResponseDto());
        this.mockMvc.perform(get("/api/v1/merchants/1")).andExpect(status().isOk());
    }

    @Test
    public void getMerchantByIdNotFoundTest() throws Exception {
        when(merchantService.getMerchantById(1)).thenThrow(RegisterNotFoundException.class);
        when(merchantMapper.toResponseDto(any())).thenReturn(new MerchantResponseDto());
        this.mockMvc.perform(get("/api/v1/merchants/1")).andExpect(status().isNotFound());
    }

    @Test
    public void saveMerchant() {
    }

    @Test
    public void updateMerchant() {
    }

    @Test
    public void deleteMerchant() {
    }

    @Test
    public void getAddressMerchant() {
    }

    @Test
    public void updatePhoneMerchant() {
    }

    @Test
    public void deleteAddressMerchant() {
    }

    @Test
    public void getPhonesMerchant() {
    }

    @Test
    public void updateAddressMerchant() {
    }

    @Test
    public void deletePhoneMerchant() {
    }

    @Test
    public void getEmailsMerchant() {
    }

    @Test
    public void updateEmailsMerchant() {
    }

    @Test
    public void deleteEmailMerchant() {
    }
}
