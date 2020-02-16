package br.com.cabal.challengemerchantapi.validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({ Default.class, UpdateMerchantValidationInterface.class})
public interface ValidationSequenceUpdate {

}
