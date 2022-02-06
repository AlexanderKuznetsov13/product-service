package ru.alex.kuznetsov.project.product.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.kuznetsov.project.product.dto.ProductResponseDto;
import ru.alex.kuznetsov.project.product.exception.NoEntityException;

import java.io.IOException;

@Tag(name = "Пользовательский API")
@RestController
@RequestMapping("/productclientresource")
public class ProductClientResourceController {

    private final Logger logger = LoggerFactory.getLogger(ProductClientResourceController.class);

    @Operation(summary = "Получить продукт")
    @GetMapping(value = "/{productId}")
    public ResponseEntity<String> getProductById(
            @Parameter(name="languageId",  required = true) @RequestParam(required = false) Integer languageId,
            @Parameter(name="currencyId", required = true) @RequestParam(required = false) Integer currencyId,
            @Parameter(name="productId", required = true) @PathVariable Integer productId) {
        logger.info(String.format("GET /getProductById id = %d; language: %d; currency: %d", productId, languageId, currencyId));
        return ResponseEntity.ok().body("OK");
    }

    @Operation(summary = "Вывести список продуктов содержищие строку в имени или описании")
    @GetMapping(value = "/productsbynameordescription")
    public ResponseEntity<String> getProductsByNameOrDescription(
            @Parameter(name="languageId",  required = true) @RequestParam(required = true) Integer languageId,
            @Parameter(name="currencyId", required = true) @RequestParam(required = true) Integer currencyId,
            @Parameter(name="value", required = true) @RequestParam(required = true)  String value) {
        logger.info(String.format("GET /productsbynameordescription value = %s; language: %d; currency: %d", value, languageId, currencyId));
        return ResponseEntity.ok().body("OK");
    }

    @Operation(summary = "Вывести весь список продуктов")
    @GetMapping(value = "/all")
    public ResponseEntity<String> getAllProducts(
            @Parameter(name="languageId",  required = true) @RequestParam(required = true) Integer languageId,
            @Parameter(name="currencyId", required = true) @RequestParam(required = true) Integer currencyId) {
        logger.info(String.format("GET /all value = %s; language: %d; currency: %d", languageId, currencyId));
        return ResponseEntity.ok().body("OK");
    }

    @ExceptionHandler({NoEntityException.class})
    public ResponseEntity handleIOException(IOException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
