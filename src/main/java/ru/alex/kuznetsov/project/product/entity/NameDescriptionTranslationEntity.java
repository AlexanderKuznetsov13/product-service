package ru.alex.kuznetsov.project.product.entity;


import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;

@Entity
@Table(name = "name_description_translation")
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
    private ProductEntity productNameDescriptionTranslationEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id", nullable = false)
    private LanguageEntity languageNameDescriptionTranslationEntity;

    public NameDescriptionTranslationEntity(){
    }

    public NameDescriptionTranslationEntity(Integer id, String name, String description, ProductEntity productNameDescriptionTranslationEntity, LanguageEntity languageNameDescriptionTranslationEntity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.productNameDescriptionTranslationEntity = productNameDescriptionTranslationEntity;
        this.languageNameDescriptionTranslationEntity = languageNameDescriptionTranslationEntity;
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

    public ProductEntity getProductNameDescriptionTranslationEntity() {
        return productNameDescriptionTranslationEntity;
    }

    public void setProductNameDescriptionTranslationEntity(ProductEntity productNameDescriptionTranslationEntity) {
        this.productNameDescriptionTranslationEntity = productNameDescriptionTranslationEntity;
    }

    public LanguageEntity getLanguageNameDescriptionTranslationEntity() {
        return languageNameDescriptionTranslationEntity;
    }

    public void setLanguageNameDescriptionTranslationEntity(LanguageEntity languageNameDescriptionTranslationEntity) {
        this.languageNameDescriptionTranslationEntity = languageNameDescriptionTranslationEntity;
    }
}
