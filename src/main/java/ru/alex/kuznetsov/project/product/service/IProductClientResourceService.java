package ru.alex.kuznetsov.project.product.service;

import ru.alex.kuznetsov.project.product.dto.ProductFullDetailsResponseDto;
import ru.alex.kuznetsov.project.product.entity.ProductEntity;

public interface IProductClientResourceService {

    ProductFullDetailsResponseDto getProductById(Integer productId, Integer languageId, Integer currencyId);
}
