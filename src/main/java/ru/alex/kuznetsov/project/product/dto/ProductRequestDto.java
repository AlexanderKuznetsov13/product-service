package ru.alex.kuznetsov.project.product.dto;


import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Продукт")
public class ProductRequestDto {

    @Schema(description = "ID продукта")
    private Integer id;

    @Schema(description = "Дата создания продукта")
    private LocalDateTime creationDate;

    @Schema(description = "Дата модификации")
    private LocalDateTime lastModificationDate;

    public ProductRequestDto() {
    }

    public ProductRequestDto(Integer id, LocalDateTime creationDate, LocalDateTime lastModificationDate) {
        this.id = id;
        this.creationDate = creationDate;
        this.lastModificationDate = lastModificationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(LocalDateTime lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    @Override
    public String toString() {
        return "ProductRequestDto{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", lastModificationDate=" + lastModificationDate +
                '}';
    }
}
