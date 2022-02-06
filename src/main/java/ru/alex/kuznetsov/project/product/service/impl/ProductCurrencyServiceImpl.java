package ru.alex.kuznetsov.project.product.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.alex.kuznetsov.project.product.dto.ProductCurrencyRequestDto;
import ru.alex.kuznetsov.project.product.dto.ProductCurrencyResponseDto;
import ru.alex.kuznetsov.project.product.entity.ProductCurrencyEntity;
import ru.alex.kuznetsov.project.product.exception.NoEntityException;
import ru.alex.kuznetsov.project.product.repository.ProductCurrencyRepository;
import ru.alex.kuznetsov.project.product.service.IProductCurrencyService;
import ru.alex.kuznetsov.project.product.util.CommonMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCurrencyServiceImpl implements IProductCurrencyService {

    private final static Logger logger = LoggerFactory.getLogger(ProductCurrencyServiceImpl.class);

    private final ProductCurrencyRepository productCurrencyRepository;

    public ProductCurrencyServiceImpl(ProductCurrencyRepository productCurrencyRepository) {
        this.productCurrencyRepository = productCurrencyRepository;
    }

    @Override
    public ProductCurrencyResponseDto getById(Integer id) {
        logger.error(String.format("getById - get productCurrency with %d", id));
        productCurrencyRepository.findById(id).orElseThrow(() -> new NoEntityException(String.format("ProductCurrency with ID = %d not found", id)));
        return CommonMapper.fromProductCurrencyEntityToProductCurrencyResponseDto(productCurrencyRepository.getById(id));
    }

    @Override
    public ProductCurrencyResponseDto create(ProductCurrencyRequestDto requestDto) {
        logger.error(String.format("create - create productCurrency"));
        ProductCurrencyEntity productCurrency = CommonMapper.fromProductCurrencyRequestDtoToProductCurrencyEntity(requestDto);
        return CommonMapper.fromProductCurrencyEntityToProductCurrencyResponseDto(productCurrencyRepository.save(productCurrency));
    }

    @Override
    public ProductCurrencyResponseDto update(ProductCurrencyRequestDto requestDto) {
        ProductCurrencyEntity productCurrency = CommonMapper.fromProductCurrencyRequestDtoToProductCurrencyEntity(requestDto);
        logger.error(String.format("update - update productCurrency with %d", productCurrency.getId()));
        return CommonMapper.fromProductCurrencyEntityToProductCurrencyResponseDto(productCurrencyRepository.save(productCurrency));
    }

    @Override
    public void deleteById(Integer id) {
        productCurrencyRepository.findById(id).orElseThrow(() -> {
            logger.error(String.format("deleteById - ProductCurrency with ID = %d not found", id));
            return new NoEntityException(String.format("ProductCurrency with ID = %d not found", id));
        });
        productCurrencyRepository.deleteById(id);
    }

    @Override
    public List<ProductCurrencyResponseDto> getAll() {
        logger.error(String.format("getAll - retrieve all productCurrencys"));
        return productCurrencyRepository.findAll().stream().map(CommonMapper::fromProductCurrencyEntityToProductCurrencyResponseDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductCurrencyResponseDto> getPriceByCurrencyAndProduct(Integer productId, Integer currencyId) {
        return productCurrencyRepository.getPriceByCurrencyAndProduct(productId, currencyId).stream().map(CommonMapper::fromProductCurrencyEntityToProductCurrencyResponseDto).collect(Collectors.toList());

    }


}

