package ru.alex.kuznetsov.project.product.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.kuznetsov.project.product.dto.UserRequestDto;
import ru.alex.kuznetsov.project.product.dto.UserResponseDto;
import ru.alex.kuznetsov.project.product.exception.NoEntityException;
import ru.alex.kuznetsov.project.product.service.IUserService;

@Tag(name = "Пользователь")
@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Создать пользователя")
    @PostMapping(value = "/create")
    public ResponseEntity<UserResponseDto> createUserType(@RequestBody UserRequestDto requestDto) {
        logger.info("POST /user/create");
        logger.debug("UserRequestDto {}", requestDto);
        UserResponseDto responseDto = userService.create(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Изменить  пользователя")
    @PutMapping(value = "/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Integer id, @RequestBody UserRequestDto requestDto) {
        logger.info(String.format("PUT /user/update id = %d", requestDto.getId()));
        requestDto.setId(id);
        UserResponseDto responseDto = userService.update(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Удалить пользователя")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        logger.info(String.format("DELETE /user/delete id = %d", id));
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler({NoEntityException.class})
    public ResponseEntity handleException(NoEntityException e) {
        logger.warn(e.getMessage());
        return ResponseEntity.notFound().build();
    }

}

