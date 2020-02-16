package br.com.cabal.challengemerchantapi.mapper;

import org.mapstruct.factory.Mappers;

public class Mapper {
    private Mapper(){
    }
    public static Object factory(final Class clazz){
        return Mappers.getMapper(clazz);
    }
}
