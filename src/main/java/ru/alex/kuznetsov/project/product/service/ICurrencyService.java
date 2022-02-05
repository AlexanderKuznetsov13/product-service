package ru.alex.kuznetsov.project.product.service;



import ru.alex.kuznetsov.project.product.dto.CurrencyRequestDto;
import ru.alex.kuznetsov.project.product.dto.CurrencyResponseDto;

import java.util.List;

public interface ICurrencyService {

    /**
     * get currency by  id
     * @param id id currency
     * @return currency
     */
    CurrencyResponseDto getById(Integer id);

    /**
     * create new currency
     * @param requestDto properties new currency
     * @return new currency
     */
    CurrencyResponseDto create(CurrencyRequestDto requestDto);

    /**
     * update old currency
     * @param requestDto new currency
     * @return currency
     */
    CurrencyResponseDto update(CurrencyRequestDto requestDto);

    /**
     * delete currency by id
     * @param id id currency
     */
    void deleteById(Integer id);

    /**
     * get all currency
     * @return list currency
     */
    List<CurrencyResponseDto> getAll();

}
