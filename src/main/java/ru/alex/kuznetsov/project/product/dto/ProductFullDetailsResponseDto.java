package ru.alex.kuznetsov.project.product.dto;


import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Продукт")
public class ProductFullDetailsResponseDto extends ProductResponseDto {

    @Schema(description = "Название")
    private String name;

    @Schema(description = "Описание")
    private String description;

    @Schema(description = "Стоимость")
    private Float price;

    @Schema(description = "Валюта")
    private String currencyName;

    @Schema(description = "Язык")
    private String languageName;

    public ProductFullDetailsResponseDto() {
    }

    public ProductFullDetailsResponseDto(ProductResponseDto product) {
        super(product.getId(),product.getCreationDate(), product.getLastModificationDate());
    }

    public ProductFullDetailsResponseDto(String name, String description, Float price, String currencyName, String languageName) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.currencyName = currencyName;
        this.languageName = languageName;
    }

    public ProductFullDetailsResponseDto(Integer id, LocalDateTime creationDate, LocalDateTime lastModificationDate, String name, String description, Float price, String currencyName, String languageName) {
        super(id, creationDate, lastModificationDate);
        this.name = name;
        this.description = description;
        this.price = price;
        this.currencyName = currencyName;
        this.languageName = languageName;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    @Override
    public String toString() {
        return "ProductFullDetailsRequestDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", currencyName='" + currencyName + '\'' +
                ", languageName='" + languageName + '\'' +
                '}';
    }
}
