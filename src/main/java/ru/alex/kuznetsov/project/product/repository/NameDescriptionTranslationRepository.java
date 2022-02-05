package ru.alex.kuznetsov.project.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alex.kuznetsov.project.product.entity.NameDescriptionTranslationEntity;

@Repository
public interface NameDescriptionTranslationRepository extends JpaRepository<NameDescriptionTranslationEntity, Integer> {

}
