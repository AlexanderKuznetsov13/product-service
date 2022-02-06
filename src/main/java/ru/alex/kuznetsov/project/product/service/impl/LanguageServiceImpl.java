package ru.alex.kuznetsov.project.product.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.alex.kuznetsov.project.product.dto.LanguageRequestDto;
import ru.alex.kuznetsov.project.product.dto.LanguageResponseDto;
import ru.alex.kuznetsov.project.product.entity.LanguageEntity;
import ru.alex.kuznetsov.project.product.exception.NoEntityException;
import ru.alex.kuznetsov.project.product.repository.LanguageRepository;
import ru.alex.kuznetsov.project.product.service.ILanguageService;
import ru.alex.kuznetsov.project.product.util.CommonMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageServiceImpl implements ILanguageService {

    private final static Logger logger = LoggerFactory.getLogger(LanguageServiceImpl.class);

    private final LanguageRepository languageRepository;

    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public LanguageResponseDto getById(Integer id) {
        logger.error(String.format("getById - get language with %d", id));
        languageRepository.findById(id).orElseThrow(() -> new NoEntityException(String.format("Language with ID = %d not found", id)));
        return CommonMapper.fromLanguageEntityToLanguageResponseDto(languageRepository.getById(id));
    }

    @Override
    public LanguageResponseDto create(LanguageRequestDto requestDto) {
        logger.error(String.format("create - create language"));
        LanguageEntity language = CommonMapper.fromLanguageRequestDtoToLanguageEntity(requestDto);
        return CommonMapper.fromLanguageEntityToLanguageResponseDto(languageRepository.save(language));
    }

    @Override
    public LanguageResponseDto update(LanguageRequestDto requestDto) {
        LanguageEntity language = CommonMapper.fromLanguageRequestDtoToLanguageEntity(requestDto);
        language.setId(requestDto.getId());
        logger.error(String.format("update - update language with %d", language.getId()));
        return CommonMapper.fromLanguageEntityToLanguageResponseDto(languageRepository.save(language));
    }

    @Override
    public void deleteById(Integer id) {
        languageRepository.findById(id).orElseThrow(() -> {
            logger.error(String.format("deleteById - Language with ID = %d not found", id));
            return new NoEntityException(String.format("Language with ID = %d not found", id));
        });
        languageRepository.deleteById(id);
    }

    @Override
    public List<LanguageResponseDto> getAll() {
        logger.error(String.format("getAll - retrieve all languages"));
        return languageRepository.findAll().stream().map(CommonMapper::fromLanguageEntityToLanguageResponseDto).collect(Collectors.toList());
    }




}

