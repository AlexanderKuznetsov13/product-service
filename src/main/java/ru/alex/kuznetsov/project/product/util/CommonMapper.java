package ru.alex.kuznetsov.project.product.util;


import ru.alex.kuznetsov.project.product.dto.LanguageRequestDto;
import ru.alex.kuznetsov.project.product.dto.LanguageResponseDto;
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

    
}

