package ru.alex.kuznetsov.project.product.entity;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "last_modification_date")
    private LocalDateTime lastModificationDate;

    @OneToMany(mappedBy = "productNameDescriptionTranslationEntity")
    private Set<NameDescriptionTranslationEntity> nameDescriptionTranslations;

    public ProductEntity(){
    }

    public ProductEntity(Integer id, LocalDateTime creationDate, LocalDateTime lastModificationDate, Set<NameDescriptionTranslationEntity> nameDescriptionTranslations) {
        this.id = id;
        this.creationDate = creationDate;
        this.lastModificationDate = lastModificationDate;
        this.nameDescriptionTranslations = nameDescriptionTranslations;
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

    public Set<NameDescriptionTranslationEntity> getNameDescriptionTranslations() {
        return nameDescriptionTranslations;
    }

    public void setNameDescriptionTranslations(Set<NameDescriptionTranslationEntity> nameDescriptionTranslations) {
        this.nameDescriptionTranslations = nameDescriptionTranslations;
    }
}
