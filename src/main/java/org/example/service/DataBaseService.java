package org.example.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.example.entities.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.sql.SQLException;
import java.util.List;

@Service
public class DataBaseService {
    private final EntityManager entityManager;

    public DataBaseService(LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        this.entityManager = entityManagerFactory.getObject().createEntityManager();
    }

    public List<User> printAllUsers(){
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("FROM User");
            entityManager.getTransaction().commit();
            return query.getResultList();
        }catch (Exception e){
            System.out.println("HQL Exception");
        }finally {
            entityManager.getTransaction().rollback();
            entityManager.close();
        }
        return null;
    }

    public List<User> printNameParam(String value){
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("SELECT * FROM User WHERE name = ?1");
            query.setParameter(1, value);
            entityManager.getTransaction().commit();
            return query.getResultList();
        }catch (Exception e){
            System.out.println("HQL Exception");
        }finally {
            entityManager.getTransaction().rollback();
            entityManager.close();
        }
        return null;
    }

    public void removeUser(int id){
        try {
            entityManager.getTransaction().begin();

            Query query = entityManager.createQuery("DELETE FROM User WHERE id = ?1");
            query.setParameter(1, id);
            query.executeUpdate();

            entityManager.getTransaction().commit();

        }catch (Exception e){
            System.out.println("HQL Exception");
        }finally {
            entityManager.getTransaction().rollback();
            entityManager.close();
        }
    }

    public void addUser(User user){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println("HQL Exception");
        }finally {
            entityManager.getTransaction().rollback();
            entityManager.close();
        }
    }

    public void updateUser(int id, User user){
        try {
            entityManager.getTransaction().begin();

            User originalUser = entityManager.find(User.class, id);
            originalUser = user;
            entityManager.merge(originalUser);

            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println("HQL Exception");
        }finally {
            entityManager.getTransaction().rollback();
            entityManager.close();
        }

    }



}