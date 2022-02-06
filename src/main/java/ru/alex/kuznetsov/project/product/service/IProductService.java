package ru.alex.kuznetsov.project.product.service;



import ru.alex.kuznetsov.project.product.dto.*;

import java.util.List;

public interface IProductService {

    /**
     * get product by  id
     * @param id id product
     * @return product
     */
    ProductResponseDto getById(Integer id);

    /**
     * create new product
     * @param requestDto properties new product
     * @return new product
     */
    ProductResponseDto create(ProductRequestDto requestDto);

    ProductResponseDto createFull(ProductFullRequestDto requestDto);

    /**
     * update old product
     * @param requestDto new product
     * @return product
     */
    ProductResponseDto update(ProductRequestDto requestDto);

    /**
     * delete product by id
     * @param id id product
     */
    void deleteById(Integer id);

    /**
     * get all product
     * @return list product
     */
    List<ProductResponseDto> getAll();


    List<ProductResponseDto> getAllProductsByNameOrDescription(String word, Integer currencyId, Integer languageId);

    List<ProductResponseDto> getAllProductsByLanguageAndProductId(Integer currencyId, Integer languageId);

}
