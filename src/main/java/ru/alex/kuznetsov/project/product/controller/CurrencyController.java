package ru.alex.kuznetsov.project.product.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.kuznetsov.project.product.dto.CurrencyRequestDto;
import ru.alex.kuznetsov.project.product.dto.CurrencyResponseDto;
import ru.alex.kuznetsov.project.product.exception.NoEntityException;
import ru.alex.kuznetsov.project.product.service.ICurrencyService;

import java.util.List;

@Tag(name = "Управление валютами")
@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private final Logger logger = LoggerFactory.getLogger(CurrencyController.class);

    private final ICurrencyService currencyService;

    public CurrencyController(ICurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Operation(summary = "Создать валюту")
    @PostMapping(value = "/create")
    public ResponseEntity<CurrencyResponseDto> createCurrency(@RequestBody CurrencyRequestDto requestDto) {
        logger.info("POST /currency/create");
        logger.debug("CurrencyRequestDto {}", requestDto);
        CurrencyResponseDto responseDto = currencyService.create(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Изменить валюту")
    @PutMapping(value = "/{id}")
    public ResponseEntity<CurrencyResponseDto> updateCurrency(@PathVariable Integer id, @RequestBody CurrencyRequestDto requestDto) {
        logger.info(String.format("PUT /currency/update id = %d", requestDto.getId()));
        requestDto.setId(id);
        CurrencyResponseDto responseDto = currencyService.update(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Получить валюту")
    @GetMapping(value = "/{id}")
    public ResponseEntity<CurrencyResponseDto> getCurrencyById(@PathVariable Integer id) {
        logger.info(String.format("GET /currency id = %d %d", id));
        CurrencyResponseDto responseDto = currencyService.getById(id);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Получить все валюты")
    @GetMapping(value = "/all")
    public ResponseEntity<List<CurrencyResponseDto>> getAllCurrency() {
        logger.info("GET All currencies /all");
        List<CurrencyResponseDto> list =  currencyService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @Operation(summary = "Удалить валюту")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteCurrency(@PathVariable Integer id) {
        logger.info(String.format("DELETE /currency/delete id = %d", id));
        currencyService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler({NoEntityException.class})
    public ResponseEntity handleException(NoEntityException e) {
        logger.warn(e.getMessage());
        return ResponseEntity.notFound().build();
    }
}
