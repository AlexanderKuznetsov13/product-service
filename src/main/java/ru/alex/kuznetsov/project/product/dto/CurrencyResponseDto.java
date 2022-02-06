package ru.alex.kuznetsov.project.product.dto;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Валюта")
public class CurrencyResponseDto {

    @Schema(description = "ID валюты")
    private Integer id;

    @Schema(description = "Название валюты")
    private String name;


    public CurrencyResponseDto() {
    }

    public CurrencyResponseDto(Integer id, String name) {
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
        return "CurrencyResponseDto{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
