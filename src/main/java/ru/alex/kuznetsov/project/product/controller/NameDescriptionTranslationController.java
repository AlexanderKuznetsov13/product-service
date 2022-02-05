package ru.alex.kuznetsov.project.product.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.kuznetsov.project.product.dto.NameDescriptionTranslationRequestDto;
import ru.alex.kuznetsov.project.product.dto.NameDescriptionTranslationResponseDto;
import ru.alex.kuznetsov.project.product.exception.NoEntityException;
import ru.alex.kuznetsov.project.product.service.INameDescriptionTranslationService;

import java.io.IOException;
import java.util.List;

@Tag(name = "Управление переводами описаний продуктов")
@RestController
@RequestMapping("/namedescriptiontranslation")
public class NameDescriptionTranslationController {

    private final Logger logger = LoggerFactory.getLogger(NameDescriptionTranslationController.class);

    private final INameDescriptionTranslationService nameDescriptionTranslationService;

    public NameDescriptionTranslationController(INameDescriptionTranslationService nameDescriptionTranslationService) {
        this.nameDescriptionTranslationService = nameDescriptionTranslationService;
    }

    @Operation(summary = "Создать запись")
    @PostMapping(value = "/create")
    public ResponseEntity<NameDescriptionTranslationResponseDto> createNameDescriptionTranslation(@RequestBody NameDescriptionTranslationRequestDto requestDto) {
        logger.info("POST /nameDescriptionTranslation/create");
        logger.debug("NameDescriptionTranslationRequestDto {}", requestDto);
        NameDescriptionTranslationResponseDto responseDto = nameDescriptionTranslationService.create(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Изменить запись")
    @PutMapping(value = "/{id}")
    public ResponseEntity<NameDescriptionTranslationResponseDto> updateNameDescriptionTranslation(@PathVariable Integer id, @RequestBody NameDescriptionTranslationRequestDto requestDto) {
        logger.info(String.format("PUT /nameDescriptionTranslation/update id = %d", requestDto.getId()));
        requestDto.setId(id);
        NameDescriptionTranslationResponseDto responseDto = nameDescriptionTranslationService.update(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Получить запись")
    @GetMapping(value = "/{id}")
    public ResponseEntity<NameDescriptionTranslationResponseDto> getNameDescriptionTranslationById(@PathVariable Integer id) {
        logger.info(String.format("GET /nameDescriptionTranslation id = %d %d", id));
        NameDescriptionTranslationResponseDto responseDto = nameDescriptionTranslationService.getById(id);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Получить все записи")
    @GetMapping(value = "/all")
    public ResponseEntity<List<NameDescriptionTranslationResponseDto>> getAllNameDescriptionTranslation() {
        logger.info("GET All currencies /all");
        List<NameDescriptionTranslationResponseDto> list =  nameDescriptionTranslationService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @Operation(summary = "Удалить запись")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteNameDescriptionTranslation(@PathVariable Integer id) {
        logger.info(String.format("DELETE /nameDescriptionTranslation/delete id = %d", id));
        nameDescriptionTranslationService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler({NoEntityException.class})
    public ResponseEntity handleIOException(IOException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
