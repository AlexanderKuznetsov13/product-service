package ru.alex.kuznetsov.project.product.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.kuznetsov.project.product.dto.LanguageRequestDto;
import ru.alex.kuznetsov.project.product.dto.LanguageResponseDto;
import ru.alex.kuznetsov.project.product.exception.NoEntityException;
import ru.alex.kuznetsov.project.product.service.ILanguageService;


import java.io.IOException;
import java.util.List;

@Tag(name = "Управление языками")
@RestController
@RequestMapping("/language")
public class LanguageController {

    private final Logger logger = LoggerFactory.getLogger(LanguageController.class);

    private final ILanguageService languageService;

    public LanguageController(ILanguageService languageService) {
        this.languageService = languageService;
    }

    @Operation(summary = "Создать язык")
    @PostMapping(value = "/create")
    public ResponseEntity<LanguageResponseDto> createLanguage(@RequestBody LanguageRequestDto requestDto) {
        logger.info("POST /language/create");
        logger.debug("LanguageRequestDto {}", requestDto);
        LanguageResponseDto responseDto = languageService.create(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Изменить язык")
    @PutMapping(value = "/{id}")
    public ResponseEntity<LanguageResponseDto> updateLanguage(@PathVariable Integer id, @RequestBody LanguageRequestDto requestDto) {
        logger.info(String.format("PUT /language/update id = %d", requestDto.getId()));
        requestDto.setId(id);
        LanguageResponseDto responseDto = languageService.update(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Получить язык")
    @GetMapping(value = "/{id}")
    public ResponseEntity<LanguageResponseDto> getLanguageById(@PathVariable Integer id) {
        logger.info(String.format("GET /language id = %d %d", id));
        LanguageResponseDto responseDto = languageService.getById(id);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Получить все языки")
    @GetMapping(value = "/all")
    public ResponseEntity<List<LanguageResponseDto>> getAllLanguage() {
        logger.info("GET All languages /all");
        List<LanguageResponseDto> list =  languageService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @Operation(summary = "Удалить язык")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteLanguage(@PathVariable Integer id) {
        logger.info(String.format("DELETE /language/delete id = %d", id));
        languageService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler({NoEntityException.class})
    public ResponseEntity handleIOException(IOException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
