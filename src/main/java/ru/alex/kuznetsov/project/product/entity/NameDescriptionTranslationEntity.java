package ru.alex.kuznetsov.project.product.entity;


import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "name_description_translation", schema = "product")
public class NameDescriptionTranslationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity productNameDescriptionTranslation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id", nullable = false)
    private LanguageEntity languageNameDescriptionTranslation;

    public NameDescriptionTranslationEntity(){
    }

    public NameDescriptionTranslationEntity(Integer id, String name, String description, ProductEntity productNameDescriptionTranslation, LanguageEntity languageNameDescriptionTranslation) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.productNameDescriptionTranslation = productNameDescriptionTranslation;
        this.languageNameDescriptionTranslation = languageNameDescriptionTranslation;
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

    public ProductEntity getProductNameDescriptionTranslation() {
        return productNameDescriptionTranslation;
    }

    public void setProductNameDescriptionTranslation(ProductEntity productNameDescriptionTranslation) {
        this.productNameDescriptionTranslation = productNameDescriptionTranslation;
    }

    public LanguageEntity getLanguageNameDescriptionTranslation() {
        return languageNameDescriptionTranslation;
    }

    public void setLanguageNameDescriptionTranslation(LanguageEntity languageNameDescriptionTranslation) {
        this.languageNameDescriptionTranslation = languageNameDescriptionTranslation;
    }
}
