package ru.alex.kuznetsov.project.product.dto;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Язык")
public class LanguageRequestDto {

    @Schema(description = "ID языка")
    private Integer id;

    @Schema(description = "Название языка")
    private String name;


    public LanguageRequestDto() {
    }

    public LanguageRequestDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LanguageRequestDto{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
