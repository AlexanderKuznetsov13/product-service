package ru.alex.kuznetsov.project.product.service.impl;

import ru.alex.kuznetsov.project.product.dto.NameDescriptionTranslationResponseDto;
import ru.alex.kuznetsov.project.product.dto.ProductCurrencyResponseDto;
import ru.alex.kuznetsov.project.product.dto.ProductFullDetailsResponseDto;
import ru.alex.kuznetsov.project.product.dto.ProductResponseDto;
import ru.alex.kuznetsov.project.product.service.*;

import java.util.List;

public class ProductClientResourceServiceImpl implements IProductClientResourceService {

    private final IProductService productService;
    private final INameDescriptionTranslationService nameDescriptionTranslationService;
    private final ICurrencyService currencyService;
    private final IProductCurrencyService productCurrencyService;
    private final ILanguageService languageService;

    public ProductClientResourceServiceImpl(IProductService productService, INameDescriptionTranslationService nameDescriptionTranslationService, ICurrencyService currencyService, IProductCurrencyService productCurrencyService, ILanguageService languageService) {
        this.productService = productService;
        this.nameDescriptionTranslationService = nameDescriptionTranslationService;
        this.currencyService = currencyService;
        this.productCurrencyService = productCurrencyService;
        this.languageService = languageService;
    }

    @Override
    public ProductFullDetailsResponseDto getProductById(Integer productId, Integer languageId, Integer currencyId) {

        List<NameDescriptionTranslationResponseDto> details = nameDescriptionTranslationService.getTranslationByLanguageAndProductId(productId, languageId);
        List<ProductCurrencyResponseDto> prices = productCurrencyService.getPriceByCurrencyAndProduct(productId, languageId);

        ProductResponseDto product = productService.getById(productId);

        return null;
    }
}
