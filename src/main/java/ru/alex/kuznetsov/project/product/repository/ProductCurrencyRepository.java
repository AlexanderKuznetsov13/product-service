package ru.alex.kuznetsov.project.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.alex.kuznetsov.project.product.entity.ProductCurrencyEntity;

import java.util.List;

@Repository
public interface ProductCurrencyRepository extends JpaRepository<ProductCurrencyEntity, Integer> {

    @Query(value ="SELECT * FROM product.product_currency pc WHERE pc.currency_id = :currencyId AND pc.product_id = :productId", nativeQuery = true)
    List<ProductCurrencyEntity> getPriceByCurrencyAndProduct(@Param("productId") int productId, @Param("currencyId") int currencyId );

}
