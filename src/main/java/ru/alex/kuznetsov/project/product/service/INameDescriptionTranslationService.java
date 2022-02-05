package ru.alex.kuznetsov.project.product.service;



import ru.alex.kuznetsov.project.product.dto.NameDescriptionTranslationRequestDto;
import ru.alex.kuznetsov.project.product.dto.NameDescriptionTranslationResponseDto;

import java.util.List;

public interface INameDescriptionTranslationService {

    /**
     * get nameDescriptionTranslation by id
     * @param id id nameDescriptionTranslation
     * @return nameDescriptionTranslation
     */
    NameDescriptionTranslationResponseDto getById(Integer id);

    /**
     * create new nameDescriptionTranslation
     * @param requestDto properties new nameDescriptionTranslation
     * @return new nameDescriptionTranslation
     */
    NameDescriptionTranslationResponseDto create(NameDescriptionTranslationRequestDto requestDto);

    /**
     * update old nameDescriptionTranslation
     * @param requestDto new nameDescriptionTranslation
     * @return nameDescriptionTranslation
     */
    NameDescriptionTranslationResponseDto update(NameDescriptionTranslationRequestDto requestDto);

    /**
     * delete nameDescriptionTranslation by id
     * @param id id nameDescriptionTranslation
     */
    void deleteById(Integer id);

    /**
     * get all nameDescriptionTranslation
     * @return list nameDescriptionTranslation
     */
    List<NameDescriptionTranslationResponseDto> getAll();

}
