package ru.alex.kuznetsov.project.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Тип пользователя")
public class UserTypeResponseDto {

    @Schema(description = "ID типа пользователя")
    private int id;

    @Schema(description = "Название типа пользователя")
    private String name;

    @Schema(description = "Описание типа пользователя")
    private String description;

    public UserTypeResponseDto() {
    }

    public UserTypeResponseDto(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UserTypeRequestDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
