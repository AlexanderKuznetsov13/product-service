package ru.alex.kuznetsov.project.product.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "language")
public class LanguageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "languageNameDescriptionTranslation")
    private Set<NameDescriptionTranslationEntity> nameDescriptionTranslations;

    public LanguageEntity(){
    }

    public LanguageEntity(Integer id, String name, Set<NameDescriptionTranslationEntity> nameDescriptionTranslations) {
        this.id = id;
        this.name = name;
        this.nameDescriptionTranslations = nameDescriptionTranslations;
    }

    public LanguageEntity(Integer id, String name) {
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

    public Set<NameDescriptionTranslationEntity> getNameDescriptionTranslations() {
        return nameDescriptionTranslations;
    }

    public void setNameDescriptionTranslations(Set<NameDescriptionTranslationEntity> nameDescriptionTranslations) {
        this.nameDescriptionTranslations = nameDescriptionTranslations;
    }
}
