package ru.alex.kuznetsov.project.product.dto;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Переводы названий и описаний продукта")
public class NameDescriptionTranslationRequestDto {

    @Schema(description = "ID записи")
    private Integer id;

    @Schema(description = "Название")
    private String name;

    @Schema(description = "Описание")
    private String description;

    @Schema(description = "ID продукта")
    private int productId;

    @Schema(description = "ID продукта")
    private int languageId;


    public NameDescriptionTranslationRequestDto() {
    }

    public NameDescriptionTranslationRequestDto(String name, String description, int productId, int languageId) {
        this.name = name;
        this.description = description;
        this.productId = productId;
        this.languageId = languageId;
    }

    public NameDescriptionTranslationRequestDto(Integer id, String name, String description, int productId, int languageId) {
        this(name, description, productId, languageId);
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    @Override
    public String toString() {
        return "NameDescriptionTranslationRequestDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", productId=" + productId +
                ", languageId=" + languageId +
                '}';
    }
}
