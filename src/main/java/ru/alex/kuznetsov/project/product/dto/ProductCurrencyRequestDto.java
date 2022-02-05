package ru.alex.kuznetsov.project.product.dto;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Переводы названий и описаний продукта")
public class ProductCurrencyRequestDto {

    @Schema(description = "ID записи")
    private Integer id;

    @Schema(description = "Цена")
    private Float price;

    @Schema(description = "ID продукта")
    private int productId;

    @Schema(description = "ID валюты")
    private int currencyId;


    public ProductCurrencyRequestDto() {
    }

    public ProductCurrencyRequestDto(Integer id, Float price, int productId, int currencyId) {
        this.id = id;
        this.price = price;
        this.productId = productId;
        this.currencyId = currencyId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    @Override
    public String toString() {
        return "ProductCurrencyRequestDto{" +
                "id=" + id +
                ", price=" + price +
                ", productId=" + productId +
                ", currencyId=" + currencyId +
                '}';
    }
}
