package ru.alex.kuznetsov.project.product.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.kuznetsov.project.product.dto.ProductFullDetailsResponseDto;
import ru.alex.kuznetsov.project.product.exception.NoEntityException;
import ru.alex.kuznetsov.project.product.service.IProductClientResourceService;

import java.util.List;

@Tag(name = "Пользовательский API")
@RestController
@RequestMapping("/productclientresource")
public class ProductClientResourceController {

    private final Logger logger = LoggerFactory.getLogger(ProductClientResourceController.class);

    private final IProductClientResourceService productClientResourceService;

    public ProductClientResourceController(IProductClientResourceService productClientResourceService) {
        this.productClientResourceService = productClientResourceService;
    }

    @Operation(summary = "Получить продукт")
    @GetMapping(value = "/{productId}")
    public ResponseEntity<ProductFullDetailsResponseDto> getProductById(
            @Parameter(name="languageId",  required = true) @RequestParam(required = false) Integer languageId,
            @Parameter(name="currencyId", required = true) @RequestParam(required = false) Integer currencyId,
            @Parameter(name="productId", required = true) @PathVariable Integer productId) {
        logger.info(String.format("GET /getProductById id = %d; language: %d; currency: %d", productId, languageId, currencyId));
        ProductFullDetailsResponseDto result = productClientResourceService.getProductById(productId, languageId, currencyId);
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Вывести список продуктов содержищие строку в имени или описании")
    @GetMapping(value = "/productsbynameordescription")
    public ResponseEntity<List<ProductFullDetailsResponseDto>> getProductsByNameOrDescription(
            @Parameter(name="languageId",  required = true) @RequestParam(required = true) Integer languageId,
            @Parameter(name="currencyId", required = true) @RequestParam(required = true) Integer currencyId,
            @Parameter(name="value", required = true) @RequestParam(required = true)  String value) {
        logger.info(String.format("GET /productsbynameordescription value = %s; language: %d; currency: %d", value, languageId, currencyId));
        List<ProductFullDetailsResponseDto> result = productClientResourceService.getAllProductsByNameOrDescription(value, languageId, currencyId);
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Вывести весь список продуктов")
    @GetMapping(value = "/all")
    public ResponseEntity<List<ProductFullDetailsResponseDto>> getAllProducts(
            @Parameter(name="languageId",  required = true) @RequestParam(required = true) Integer languageId,
            @Parameter(name="currencyId", required = true) @RequestParam(required = true) Integer currencyId) {
        logger.info(String.format("GET /all products language: %d; currency: %d", languageId, currencyId));
        List<ProductFullDetailsResponseDto> result = productClientResourceService.getAllProductsByLanguageAndCurrency(languageId, currencyId);
        return ResponseEntity.ok().body(result);
    }

    @ExceptionHandler({NoEntityException.class})
    public ResponseEntity handleException(NoEntityException e) {
        logger.warn(e.getMessage());
        return ResponseEntity.notFound().build();
    }

}
