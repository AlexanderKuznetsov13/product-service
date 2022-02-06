package ru.alex.kuznetsov.project.product.service;



import ru.alex.kuznetsov.project.product.dto.ProductCurrencyRequestDto;
import ru.alex.kuznetsov.project.product.dto.ProductCurrencyResponseDto;

import java.util.List;

public interface IProductCurrencyService {

    /**
     * get productProductCurrency by  id
     * @param id id productProductCurrency
     * @return productProductCurrency
     */
    ProductCurrencyResponseDto getById(Integer id);

    /**
     * create new productProductCurrency
     * @param requestDto properties new productProductCurrency
     * @return new productProductCurrency
     */
    ProductCurrencyResponseDto create(ProductCurrencyRequestDto requestDto);

    /**
     * update old productProductCurrency
     * @param requestDto new productProductCurrency
     * @return productProductCurrency
     */
    ProductCurrencyResponseDto update(ProductCurrencyRequestDto requestDto);

    /**
     * delete productProductCurrency by id
     * @param id id productProductCurrency
     */
    void deleteById(Integer id);

    /**
     * get all productProductCurrency
     * @return list productProductCurrency
     */
    List<ProductCurrencyResponseDto> getAll();

    List<ProductCurrencyResponseDto> getPriceByCurrencyAndProduct(Integer productId, Integer currencyId);

}
