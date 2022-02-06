package ru.alex.kuznetsov.project.product.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.alex.kuznetsov.project.product.dto.CurrencyRequestDto;
import ru.alex.kuznetsov.project.product.dto.CurrencyResponseDto;
import ru.alex.kuznetsov.project.product.entity.CurrencyEntity;
import ru.alex.kuznetsov.project.product.exception.NoEntityException;
import ru.alex.kuznetsov.project.product.repository.CurrencyRepository;
import ru.alex.kuznetsov.project.product.service.ICurrencyService;
import ru.alex.kuznetsov.project.product.util.CommonMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyServiceImpl implements ICurrencyService {

    private final static Logger logger = LoggerFactory.getLogger(CurrencyServiceImpl.class);

    private final CurrencyRepository currencyRepository;

    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public CurrencyResponseDto getById(Integer id) {
        logger.error(String.format("getById - get currency with %id", id));
        currencyRepository.findById(id).orElseThrow(() -> new NoEntityException(String.format("Currency with ID = %d not found", id)));
        return CommonMapper.fromCurrencyEntityToCurrencyResponseDto(currencyRepository.getById(id));
    }

    @Override
    public CurrencyResponseDto create(CurrencyRequestDto requestDto) {
        logger.error(String.format("create - create currency"));
        CurrencyEntity currency = CommonMapper.fromCurrencyRequestDtoToCurrencyEntity(requestDto);
        return CommonMapper.fromCurrencyEntityToCurrencyResponseDto(currencyRepository.save(currency));
    }

    @Override
    public CurrencyResponseDto update(CurrencyRequestDto requestDto) {
        CurrencyEntity currency = CommonMapper.fromCurrencyRequestDtoToCurrencyEntity(requestDto);
        logger.error(String.format("update - update currency with %id", currency.getId()));
        return CommonMapper.fromCurrencyEntityToCurrencyResponseDto(currencyRepository.save(currency));
    }

    @Override
    public void deleteById(Integer id) {
        currencyRepository.findById(id).orElseThrow(() -> {
            logger.error(String.format("deleteById - Currency with ID = %d not found", id));
            return new NoEntityException(String.format("Currency with ID = %d not found", id));
        });
        currencyRepository.deleteById(id);
    }

    @Override
    public List<CurrencyResponseDto> getAll() {
        logger.error(String.format("getAll - retrieve all currencys"));
        return currencyRepository.findAll().stream().map(CommonMapper::fromCurrencyEntityToCurrencyResponseDto).collect(Collectors.toList());
    }




}

