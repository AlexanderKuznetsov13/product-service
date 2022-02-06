package ru.alex.kuznetsov.project.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alex.kuznetsov.project.product.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    /**
     * find user with login
     * @param login user login
     * @return user
     */
    UserEntity findByLogin(String login);

}
