package ru.alex.kuznetsov.project.product.util;


import ru.alex.kuznetsov.project.product.dto.*;
import ru.alex.kuznetsov.project.product.entity.CurrencyEntity;
import ru.alex.kuznetsov.project.product.entity.LanguageEntity;
import ru.alex.kuznetsov.project.product.entity.NameDescriptionTranslationEntity;
import ru.alex.kuznetsov.project.product.entity.ProductEntity;

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

    public static ProductEntity fromProductRequestDtoToProductEntity(ProductRequestDto requestDto) {
        ProductEntity product = new ProductEntity();
        product.setId(requestDto.getId());
        product.setCreationDate(requestDto.getCreationDate());
        product.setLastModificationDate(requestDto.getLastModificationDate());

        return product;
    }

    public static ProductResponseDto fromProductEntityToProductResponseDto(ProductEntity product) {
        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setCreationDate(product.getCreationDate());
        responseDto.setLastModificationDate(product.getLastModificationDate());
        return responseDto;
    }


    public static NameDescriptionTranslationEntity fromNameDescriptionTranslationRequestDtoToNameDescriptionTranslationEntity(NameDescriptionTranslationRequestDto requestDto) {
        NameDescriptionTranslationEntity nameDescriptionTranslation = new NameDescriptionTranslationEntity();
        nameDescriptionTranslation.setId(requestDto.getId());
        nameDescriptionTranslation.setName(requestDto.getName());
        nameDescriptionTranslation.setDescription(requestDto.getDescription());

        return nameDescriptionTranslation;
    }

    public static NameDescriptionTranslationResponseDto fromNameDescriptionTranslationEntityToNameDescriptionTranslationResponseDto(NameDescriptionTranslationEntity nameDescriptionTranslation) {
        NameDescriptionTranslationResponseDto responseDto = new NameDescriptionTranslationResponseDto();
        responseDto.setId(nameDescriptionTranslation.getId());
        responseDto.setName(nameDescriptionTranslation.getName());
        responseDto.setDescription(nameDescriptionTranslation.getDescription());
        return responseDto;
    }



    
}

