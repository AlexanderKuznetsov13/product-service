package ru.alex.kuznetsov.project.product.util;


import ru.alex.kuznetsov.project.product.dto.*;
import ru.alex.kuznetsov.project.product.entity.*;

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

    public static ProductCurrencyEntity fromProductCurrencyRequestDtoToProductCurrencyEntity(ProductCurrencyRequestDto requestDto) {
        ProductCurrencyEntity productCurrency = new ProductCurrencyEntity();
        productCurrency.setId(requestDto.getId());
        productCurrency.setPrice(requestDto.getPrice());

        return productCurrency;
    }

    public static ProductCurrencyResponseDto fromProductCurrencyEntityToProductCurrencyResponseDto(ProductCurrencyEntity productCurrency) {
        ProductCurrencyResponseDto responseDto = new ProductCurrencyResponseDto();
        responseDto.setId(productCurrency.getId());
        responseDto.setPrice(productCurrency.getPrice());
        return responseDto;
    }

    public static UserTypeEntity fromUserTypeRequestDtoToUserTypeEntity(UserTypeRequestDto requestDto) {
        UserTypeEntity usersType = new UserTypeEntity();
        usersType.setId(requestDto.getId());
        usersType.setName(requestDto.getName());
        usersType.setDescription(requestDto.getDescription());
        return usersType;
    }

    public static UserTypeResponseDto fromUserTypeEntityToUserTypeResponseDto(UserTypeEntity userType) {
        UserTypeResponseDto responseDto = new UserTypeResponseDto();
        responseDto.setId(userType.getId());
        responseDto.setName(userType.getName());
        responseDto.setDescription(userType.getDescription());

        return responseDto;
    }

    public static UserEntity fromUsersRequestDtoToUsersEntity(UserRequestDto requestDto) {
        UserEntity user = new UserEntity();
        user.setId(requestDto.getId());
        user.setName(requestDto.getName());
        user.setSurname(requestDto.getSurname());
        user.setMiddlename(requestDto.getMiddlename());
        user.setLogin(requestDto.getNickname());
        user.setPassword(requestDto.getPassword());
        return user;
    }

    public static UserResponseDto fromUserEntityToUserResponseDto(UserEntity userType) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(userType.getId());
        responseDto.setName(userType.getName());
        responseDto.setSurname(userType.getSurname());
        responseDto.setMiddlename(userType.getMiddlename());
        responseDto.setNickname(userType.getLogin());
        responseDto.setPassword(userType.getPassword());
        responseDto.setUserTypeId(userType.getUserTypeUser().getId());
        return responseDto;

    }



    
}

