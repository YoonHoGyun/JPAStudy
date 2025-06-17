package com.example.jpaStudy.main;

import com.example.jpaStudy.domain.Address;
import jakarta.persistence.*;
import com.example.jpaStudy.domain.User;

import java.time.LocalDateTime;

public class UserSaveMain {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("jpabegin");

        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Address address = new Address("test", "abcd", "1234");
            User user = new User("user@user.com", "user", address, LocalDateTime.now());
            entityManager.persist(user);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        } finally {
            entityManager.close();
        }

        emf.close();
    }
}
