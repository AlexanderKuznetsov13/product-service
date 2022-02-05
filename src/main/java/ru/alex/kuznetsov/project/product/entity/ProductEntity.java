package ru.alex.kuznetsov.project.product.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

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

    public ProductEntity(){
    }

    public ProductEntity(Integer id, LocalDateTime creationDate, LocalDateTime lastModificationDate) {
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
}
