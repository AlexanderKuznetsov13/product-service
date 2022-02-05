package ru.alex.kuznetsov.project.product.service;



import ru.alex.kuznetsov.project.product.dto.LanguageRequestDto;
import ru.alex.kuznetsov.project.product.dto.LanguageResponseDto;

import java.util.List;

public interface ILanguageService {

    /**
     * get language by  id
     * @param id id language
     * @return language
     */
    LanguageResponseDto getById(Integer id);

    /**
     * create new language
     * @param requestDto properties new language
     * @return new language
     */
    LanguageResponseDto create(LanguageRequestDto requestDto);

    /**
     * update old language
     * @param requestDto new language
     * @return language
     */
    LanguageResponseDto update(LanguageRequestDto requestDto);

    /**
     * delete language by id
     * @param id id language
     */
    void deleteById(Integer id);

    /**
     * get all language
     * @return list language
     */
    List<LanguageResponseDto> getAll();

}
