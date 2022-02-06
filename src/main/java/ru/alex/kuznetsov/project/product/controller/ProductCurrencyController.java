package ru.alex.kuznetsov.project.product.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.kuznetsov.project.product.dto.ProductCurrencyRequestDto;
import ru.alex.kuznetsov.project.product.dto.ProductCurrencyResponseDto;
import ru.alex.kuznetsov.project.product.exception.NoEntityException;
import ru.alex.kuznetsov.project.product.service.IProductCurrencyService;

import java.util.List;

@Tag(name = "Управление ценами для продукта")
@RestController
@RequestMapping("/productcurrency")
public class ProductCurrencyController {

    private final Logger logger = LoggerFactory.getLogger(ProductCurrencyController.class);

    private final IProductCurrencyService productCurrencyService;

    public ProductCurrencyController(IProductCurrencyService productCurrencyService) {
        this.productCurrencyService = productCurrencyService;
    }

    @Operation(summary = "Создать валюту")
    @PostMapping(value = "/create")
    public ResponseEntity<ProductCurrencyResponseDto> createProductCurrency(@RequestBody ProductCurrencyRequestDto requestDto) {
        logger.info("POST /productProductCurrency/create");
        logger.debug("ProductCurrencyRequestDto {}", requestDto);
        ProductCurrencyResponseDto responseDto = productCurrencyService.create(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Изменить валюту")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductCurrencyResponseDto> updateProductCurrency(@PathVariable Integer id, @RequestBody ProductCurrencyRequestDto requestDto) {
        logger.info(String.format("PUT /productProductCurrency/update id = %d", requestDto.getId()));
        requestDto.setId(id);
        ProductCurrencyResponseDto responseDto = productCurrencyService.update(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Получить валюту")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductCurrencyResponseDto> getProductCurrencyById(@PathVariable Integer id) {
        logger.info(String.format("GET /productProductCurrency id = %d %d", id));
        ProductCurrencyResponseDto responseDto = productCurrencyService.getById(id);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Получить все валюты")
    @GetMapping(value = "/all")
    public ResponseEntity<List<ProductCurrencyResponseDto>> getAllProductCurrency() {
        logger.info("GET All currencies /all");
        List<ProductCurrencyResponseDto> list =  productCurrencyService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @Operation(summary = "Удалить валюту")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteProductCurrency(@PathVariable Integer id) {
        logger.info(String.format("DELETE /productProductCurrency/delete id = %d", id));
        productCurrencyService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler({NoEntityException.class})
    public ResponseEntity handleException(NoEntityException e) {
        logger.warn(e.getMessage());
        return ResponseEntity.notFound().build();
    }
}
