package ru.alex.kuznetsov.project.product.entity;


import javax.persistence.*;

@Entity
@Table(name = "name_description_translation")
public class ProductCurrencyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "price")
    private Float price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity productProductCurrency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_id", nullable = false)
    private LanguageEntity currencyProductCurrency;

    public ProductCurrencyEntity(){
    }

    public ProductCurrencyEntity(Integer id, Float price, ProductEntity productProductCurrency, LanguageEntity currencyProductCurrency) {
        this.id = id;
        this.price = price;
        this.productProductCurrency = productProductCurrency;
        this.currencyProductCurrency = currencyProductCurrency;
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

    public ProductEntity getProductProductCurrency() {
        return productProductCurrency;
    }

    public void setProductProductCurrency(ProductEntity productProductCurrency) {
        this.productProductCurrency = productProductCurrency;
    }

    public LanguageEntity getCurrencyProductCurrency() {
        return currencyProductCurrency;
    }

    public void setCurrencyProductCurrency(LanguageEntity currencyProductCurrency) {
        this.currencyProductCurrency = currencyProductCurrency;
    }
}
