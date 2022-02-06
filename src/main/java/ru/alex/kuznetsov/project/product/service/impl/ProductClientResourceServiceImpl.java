package ru.alex.kuznetsov.project.product.service.impl;

import org.springframework.stereotype.Service;
import ru.alex.kuznetsov.project.product.dto.NameDescriptionTranslationResponseDto;
import ru.alex.kuznetsov.project.product.dto.ProductCurrencyResponseDto;
import ru.alex.kuznetsov.project.product.dto.ProductFullDetailsResponseDto;
import ru.alex.kuznetsov.project.product.dto.ProductResponseDto;
import ru.alex.kuznetsov.project.product.entity.*;
import ru.alex.kuznetsov.project.product.exception.NoEntityException;
import ru.alex.kuznetsov.project.product.repository.ProductRepository;
import ru.alex.kuznetsov.project.product.service.*;
import ru.alex.kuznetsov.project.product.util.CommonMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductClientResourceServiceImpl implements IProductClientResourceService {

    private final IProductService productService;
    private final INameDescriptionTranslationService nameDescriptionTranslationService;
    private final ICurrencyService currencyService;
    private final IProductCurrencyService productCurrencyService;
    private final ILanguageService languageService;
    private final ProductRepository productRepository;

    public ProductClientResourceServiceImpl(IProductService productService, INameDescriptionTranslationService nameDescriptionTranslationService, ICurrencyService currencyService, IProductCurrencyService productCurrencyService, ILanguageService languageService, ProductRepository productRepository) {
        this.productService = productService;
        this.nameDescriptionTranslationService = nameDescriptionTranslationService;
        this.currencyService = currencyService;
        this.productCurrencyService = productCurrencyService;
        this.languageService = languageService;
        this.productRepository = productRepository;
    }

    @Override
    public ProductFullDetailsResponseDto getProductById(Integer productId, Integer languageId, Integer currencyId) {
        ProductFullDetailsResponseDto product = null;
        ProductResponseDto tProduct = productService.getById(productId);
        List<NameDescriptionTranslationResponseDto> details = nameDescriptionTranslationService.getTranslationByLanguageAndProductId(productId, languageId);
        List<ProductCurrencyResponseDto> prices = productCurrencyService.getPriceByCurrencyAndProduct(productId, currencyId);

        if (details.size()>0 && prices.size()>0) {
            NameDescriptionTranslationResponseDto detail = details.get(0);
            ProductCurrencyResponseDto price = prices.get(0);
            product = new ProductFullDetailsResponseDto(tProduct);
            product.setName(detail.getName());
            product.setDescription(detail.getDescription());
            product.setPrice(price.getPrice());
            product.setCurrencyName(currencyService.getById(currencyId).getName());
            product.setLanguageName(languageService.getById(languageId).getName());
        } else {
            throw new NoEntityException(String.format("Product is not found with ID: %d, LanguageId: %d, CurrencyId: %d",
                    productId, languageId, currencyId));
        }

        return product;
    }

    @Override
    public List<ProductFullDetailsResponseDto> getAllProductsByLanguageAndCurrency(Integer languageId, Integer currencyId) {
        List<ProductResponseDto> list = productService.getAllProductsByLanguageAndProductId(currencyId, languageId);

        List<ProductFullDetailsResponseDto> result = new ArrayList<>();
        if (list.size() == 0)
            throw new NoEntityException(String.format("Products are not found with LanguageId: %d, CurrencyId: %d",
                    languageId, currencyId));

        for (int i = 0; i < list.size(); i++) {
            ProductResponseDto entity = list.get(i);
            ProductFullDetailsResponseDto element = getProductById(list.get(i).getId(),  languageId, currencyId);
            result.add(element);
        }

        return result;
    }

}
