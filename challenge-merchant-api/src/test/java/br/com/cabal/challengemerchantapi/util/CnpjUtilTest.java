package br.com.cabal.challengemerchantapi.util;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class CnpjUtilTest {

    @Test
    public void invalidCnpjTest() {
        String invalidCnpj = "03204813100000";
        assertThat(CnpjUtils.isValid(invalidCnpj)).isFalse();
    }

    @Test
    public void validCnpjTest() {
        String valid = "26805123000193";
        assertThat(CnpjUtils.isValid(valid)).isTrue();
    }


}
