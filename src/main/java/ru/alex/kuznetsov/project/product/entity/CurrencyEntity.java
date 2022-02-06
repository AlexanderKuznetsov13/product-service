package ru.alex.kuznetsov.project.product.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "currency", schema = "product")
public class CurrencyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "currencyProductCurrency")
    private Set<ProductCurrencyEntity> productCurrencies;

    public CurrencyEntity(){
    }

    public CurrencyEntity(Integer id, String name) {
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
}
