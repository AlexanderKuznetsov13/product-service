package ru.alex.kuznetsov.project.product.service.impl;

import org.springframework.stereotype.Service;
import ru.alex.kuznetsov.project.product.dto.NameDescriptionTranslationResponseDto;
import ru.alex.kuznetsov.project.product.dto.ProductCurrencyResponseDto;
import ru.alex.kuznetsov.project.product.dto.ProductFullDetailsResponseDto;
import ru.alex.kuznetsov.project.product.exception.NoEntityException;
import ru.alex.kuznetsov.project.product.service.*;

import java.util.List;

@Service
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
        ProductFullDetailsResponseDto product = new ProductFullDetailsResponseDto();
        List<NameDescriptionTranslationResponseDto> details = nameDescriptionTranslationService.getTranslationByLanguageAndProductId(productId, languageId);
        List<ProductCurrencyResponseDto> prices = productCurrencyService.getPriceByCurrencyAndProduct(productId, currencyId);

        if (details.size()>0 && prices.size()>0) {
            NameDescriptionTranslationResponseDto detail = details.get(0);
            ProductCurrencyResponseDto price = prices.get(0);
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
}
