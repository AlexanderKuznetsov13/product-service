package ru.alex.kuznetsov.project.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.alex.kuznetsov.project.product.entity.NameDescriptionTranslationEntity;
import ru.alex.kuznetsov.project.product.entity.ProductEntity;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    @Query(value ="SELECT * FROM product.product p" +
            " inner join product.product_currency pc on p.id = pc.product_id" +
            " inner join product.name_description_translation ndt on p.id = ndt.product_id" +
            " where pc.currency_id = :currencyId and ndt.language_id = :languageId", nativeQuery = true)
    List<ProductEntity> getTranslationByLanguageAndProductId(@Param("currencyId") Integer currencyId, @Param("languageId") Integer languageId );


}
