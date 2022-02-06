package ru.alex.kuznetsov.project.product.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.alex.kuznetsov.project.product.dto.NameDescriptionTranslationRequestDto;
import ru.alex.kuznetsov.project.product.dto.NameDescriptionTranslationResponseDto;
import ru.alex.kuznetsov.project.product.entity.NameDescriptionTranslationEntity;
import ru.alex.kuznetsov.project.product.exception.NoEntityException;
import ru.alex.kuznetsov.project.product.repository.NameDescriptionTranslationRepository;
import ru.alex.kuznetsov.project.product.service.INameDescriptionTranslationService;
import ru.alex.kuznetsov.project.product.util.CommonMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NameDescriptionTranslationServiceImpl implements INameDescriptionTranslationService {

    private final static Logger logger = LoggerFactory.getLogger(NameDescriptionTranslationServiceImpl.class);

    private final NameDescriptionTranslationRepository nameDescriptionTranslationRepository;

    public NameDescriptionTranslationServiceImpl(NameDescriptionTranslationRepository nameDescriptionTranslationRepository) {
        this.nameDescriptionTranslationRepository = nameDescriptionTranslationRepository;
    }

    @Override
    public NameDescriptionTranslationResponseDto getById(Integer id) {
        logger.error(String.format("getById - get nameDescriptionTranslation with %id", id));
        nameDescriptionTranslationRepository.findById(id).orElseThrow(() -> new NoEntityException(String.format("NameDescriptionTranslation with ID = %d not found", id)));
        return CommonMapper.fromNameDescriptionTranslationEntityToNameDescriptionTranslationResponseDto(nameDescriptionTranslationRepository.getById(id));
    }

    @Override
    public NameDescriptionTranslationResponseDto create(NameDescriptionTranslationRequestDto requestDto) {
        logger.error(String.format("create - create nameDescriptionTranslation"));
        NameDescriptionTranslationEntity nameDescriptionTranslation = CommonMapper.fromNameDescriptionTranslationRequestDtoToNameDescriptionTranslationEntity(requestDto);
        return CommonMapper.fromNameDescriptionTranslationEntityToNameDescriptionTranslationResponseDto(nameDescriptionTranslationRepository.save(nameDescriptionTranslation));
    }

    @Override
    public NameDescriptionTranslationResponseDto update(NameDescriptionTranslationRequestDto requestDto) {
        NameDescriptionTranslationEntity nameDescriptionTranslation = CommonMapper.fromNameDescriptionTranslationRequestDtoToNameDescriptionTranslationEntity(requestDto);
        logger.error(String.format("update - update nameDescriptionTranslation with %id", nameDescriptionTranslation.getId()));
        return CommonMapper.fromNameDescriptionTranslationEntityToNameDescriptionTranslationResponseDto(nameDescriptionTranslationRepository.save(nameDescriptionTranslation));
    }

    @Override
    public void deleteById(Integer id) {
        nameDescriptionTranslationRepository.findById(id).orElseThrow(() -> {
            logger.error(String.format("deleteById - NameDescriptionTranslation with ID = %d not found", id));
            return new NoEntityException(String.format("NameDescriptionTranslation with ID = %d not found", id));
        });
        nameDescriptionTranslationRepository.deleteById(id);
    }

    @Override
    public List<NameDescriptionTranslationResponseDto> getAll() {
        logger.error(String.format("getAll - retrieve all nameDescriptionTranslations"));
        return nameDescriptionTranslationRepository.findAll().stream().map(CommonMapper::fromNameDescriptionTranslationEntityToNameDescriptionTranslationResponseDto).collect(Collectors.toList());
    }




}

