package com.example.jpaStudy.service;

import com.example.jpaStudy.domain.User;
import com.example.jpaStudy.jpa.EMF;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RemoveUserService {

    public void removeUser(String email){
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            User user = em.find(User.class, email);
            if(user == null) throw new Exception();
            em.remove(user);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }
}
