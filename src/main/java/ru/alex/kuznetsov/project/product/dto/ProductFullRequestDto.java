package ru.alex.kuznetsov.project.product.dto;


import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Продукт")
public class ProductFullRequestDto extends ProductRequestDto{

    @Schema(description = "Название")
    private String name;

    @Schema(description = "Описание")
    private String description;

    @Schema(description = "ID языка")
    private Integer languageId;

    @Schema(description = "ID валюты")
    private Integer currencyId;

    @Schema(description = "Стоимость")
    private Float price;

    public ProductFullRequestDto() {
    }

    public ProductFullRequestDto(String name, String description, Integer languageId, Integer currencyId, Float price) {
        this.name = name;
        this.description = description;
        this.languageId = languageId;
        this.currencyId = currencyId;
        this.price = price;
    }

    public ProductFullRequestDto(Integer id, LocalDateTime creationDate, LocalDateTime lastModificationDate, String name, String description, Integer languageId, Integer currencyId, Float price) {
        super(id, creationDate, lastModificationDate);
        this.name = name;
        this.description = description;
        this.languageId = languageId;
        this.currencyId = currencyId;
        this.price = price;
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

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductFullRequestDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", languageId=" + languageId +
                ", currencyId=" + currencyId +
                ", price=" + price +
                '}';
    }
}
