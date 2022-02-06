package ru.alex.kuznetsov.project.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.alex.kuznetsov.project.product.dto.NameDescriptionTranslationResponseDto;
import ru.alex.kuznetsov.project.product.entity.NameDescriptionTranslationEntity;

import java.util.List;

@Repository
public interface NameDescriptionTranslationRepository extends JpaRepository<NameDescriptionTranslationEntity, Integer> {


    @Query(value ="SELECT tr FROM product.name_description_translation tr  WHERE tr.language_id = :languageId AND tr.product_id = :productId", nativeQuery = true)
    List<NameDescriptionTranslationEntity> getTranslationByLanguageAndProductId(@Param("productId") int productId, @Param("languageId") int languageId );
}
