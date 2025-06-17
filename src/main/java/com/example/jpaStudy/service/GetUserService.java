package com.example.jpaStudy.service;

import com.example.jpaStudy.domain.User;
import com.example.jpaStudy.jpa.EMF;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class GetUserService {

    public User getUser(String email){
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            User user = em.find(User.class, email);
            if(user == null) throw new Exception();
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }
}
