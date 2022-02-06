package ru.alex.kuznetsov.project.product.service;

import ru.alex.kuznetsov.project.product.dto.ProductFullDetailsResponseDto;

import java.util.List;

public interface IProductClientResourceService {

    ProductFullDetailsResponseDto getProductById(Integer productId, Integer languageId, Integer currencyId);

    List<ProductFullDetailsResponseDto> getAllProductsByLanguageAndCurrency(Integer languageId, Integer currencyId);

}
