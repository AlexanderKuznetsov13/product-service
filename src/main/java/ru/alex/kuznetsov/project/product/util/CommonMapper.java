package ru.alex.kuznetsov.project.product.util;


import ru.alex.kuznetsov.project.product.dto.CurrencyRequestDto;
import ru.alex.kuznetsov.project.product.dto.CurrencyResponseDto;
import ru.alex.kuznetsov.project.product.dto.LanguageRequestDto;
import ru.alex.kuznetsov.project.product.dto.LanguageResponseDto;
import ru.alex.kuznetsov.project.product.entity.CurrencyEntity;
import ru.alex.kuznetsov.project.product.entity.LanguageEntity;

public class CommonMapper {

    public static LanguageEntity fromLanguageRequestDtoToLanguageEntity(LanguageRequestDto requestDto) {
        LanguageEntity language = new LanguageEntity();
        language.setId(requestDto.getId());
        language.setName(requestDto.getName());

        return language;
    }

    public static LanguageResponseDto fromLanguageEntityToLanguageResponseDto(LanguageEntity language) {
        LanguageResponseDto responseDto = new LanguageResponseDto();
        responseDto.setId(language.getId());
        responseDto.setName(language.getName());
        return responseDto;
    }

    public static CurrencyEntity fromCurrencyRequestDtoToCurrencyEntity(CurrencyRequestDto requestDto) {
        CurrencyEntity currency = new CurrencyEntity();
        currency.setId(requestDto.getId());
        currency.setName(requestDto.getName());

        return currency;
    }

    public static CurrencyResponseDto fromCurrencyEntityToCurrencyResponseDto(CurrencyEntity currency) {
        CurrencyResponseDto responseDto = new CurrencyResponseDto();
        responseDto.setId(currency.getId());
        responseDto.setName(currency.getName());
        return responseDto;
    }

    
}

