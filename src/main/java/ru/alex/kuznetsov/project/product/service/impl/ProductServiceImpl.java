package ru.alex.kuznetsov.project.product.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.alex.kuznetsov.project.product.dto.*;
import ru.alex.kuznetsov.project.product.entity.ProductEntity;
import ru.alex.kuznetsov.project.product.exception.NoEntityException;
import ru.alex.kuznetsov.project.product.repository.ProductRepository;
import ru.alex.kuznetsov.project.product.service.*;
import ru.alex.kuznetsov.project.product.util.CommonMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

    private final static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;
    private final IProductCurrencyService productCurrencyService;
    private final INameDescriptionTranslationService nameDescriptionTranslationService;

    public ProductServiceImpl(ProductRepository productRepository, IProductCurrencyService productCurrencyService, INameDescriptionTranslationService nameDescriptionTranslationService) {
        this.productRepository = productRepository;
        this.productCurrencyService = productCurrencyService;
        this.nameDescriptionTranslationService = nameDescriptionTranslationService;
    }

    @Override
    public ProductResponseDto getById(Integer id) {
        logger.error(String.format("getById - get product with %d", id));
        productRepository.findById(id).orElseThrow(() -> new NoEntityException(String.format("Product with ID = %d not found", id)));
        return CommonMapper.fromProductEntityToProductResponseDto(productRepository.getById(id));
    }

    @Override
    public ProductResponseDto create(ProductRequestDto requestDto) {
        logger.error(String.format("create - create product"));
        ProductEntity product = CommonMapper.fromProductRequestDtoToProductEntity(requestDto);
        return CommonMapper.fromProductEntityToProductResponseDto(productRepository.save(product));
    }

    @Override
    public ProductResponseDto createFull(ProductFullRequestDto requestDto) {
        ProductEntity product = CommonMapper.fromProductRequestDtoToProductEntity(requestDto);
        product = productRepository.save(product);

        NameDescriptionTranslationRequestDto translationRequestDto = new NameDescriptionTranslationRequestDto(requestDto.getName(), requestDto.getDescription(), product.getId(), requestDto.getLanguageId());
        nameDescriptionTranslationService.create(translationRequestDto);

        ProductCurrencyRequestDto request = new ProductCurrencyRequestDto(requestDto.getPrice(), product.getId(), requestDto.getCurrencyId());
        productCurrencyService.create(request);
        return CommonMapper.fromProductEntityToProductResponseDto(product);
    }

    @Override
    public ProductResponseDto update(ProductRequestDto requestDto) {
        ProductEntity product = CommonMapper.fromProductRequestDtoToProductEntity(requestDto);
        product.setId(requestDto.getId());
        logger.error(String.format("update - update product with %d", product.getId()));
        return CommonMapper.fromProductEntityToProductResponseDto(productRepository.save(product));
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.findById(id).orElseThrow(() -> {
            logger.error(String.format("deleteById - Product with ID = %d not found", id));
            return new NoEntityException(String.format("Product with ID = %d not found", id));
        });
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductResponseDto> getAll() {
        logger.error(String.format("getAll - retrieve all products"));
        return productRepository.findAll().stream().map(CommonMapper::fromProductEntityToProductResponseDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductResponseDto> getAllProductsByNameOrDescription(String word, Integer currencyId, Integer languageId) {
        return productRepository.getAllProductsByNameOrDescription(word, currencyId, languageId).stream().map(CommonMapper::fromProductEntityToProductResponseDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductResponseDto> getAllProductsByLanguageAndProductId(Integer currencyId, Integer languageId) {
        return productRepository.getTranslationByLanguageAndProductId(currencyId, languageId).stream().map(CommonMapper::fromProductEntityToProductResponseDto).collect(Collectors.toList());
    }


}

