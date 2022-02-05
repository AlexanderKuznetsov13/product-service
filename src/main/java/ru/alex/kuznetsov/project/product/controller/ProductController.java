package ru.alex.kuznetsov.project.product.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.kuznetsov.project.product.dto.ProductRequestDto;
import ru.alex.kuznetsov.project.product.dto.ProductResponseDto;
import ru.alex.kuznetsov.project.product.exception.NoEntityException;
import ru.alex.kuznetsov.project.product.service.IProductService;

import java.io.IOException;
import java.util.List;

@Tag(name = "Управление продуктами")
@RestController
@RequestMapping("/product")
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Создать продукт")
    @PostMapping(value = "/create")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto requestDto) {
        logger.info("POST /product/create");
        logger.debug("ProductRequestDto {}", requestDto);
        ProductResponseDto responseDto = productService.create(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Изменить продукт")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable Integer id, @RequestBody ProductRequestDto requestDto) {
        logger.info(String.format("PUT /product/update id = %d", requestDto.getId()));
        requestDto.setId(id);
        ProductResponseDto responseDto = productService.update(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Получить продукт")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Integer id) {
        logger.info(String.format("GET /product id = %d %d", id));
        ProductResponseDto responseDto = productService.getById(id);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Получить все продукты")
    @GetMapping(value = "/all")
    public ResponseEntity<List<ProductResponseDto>> getAllProduct() {
        logger.info("GET All products /all");
        List<ProductResponseDto> list =  productService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @Operation(summary = "Удалить продукт")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id) {
        logger.info(String.format("DELETE /product/delete id = %d", id));
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler({NoEntityException.class})
    public ResponseEntity handleIOException(IOException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
