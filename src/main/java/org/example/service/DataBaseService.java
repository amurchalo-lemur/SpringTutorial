package org.example.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.example.entities.User;
import org.example.userRepoasitories.UserRepositoryCrudInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class DataBaseService {

    private final UserRepositoryCrudInterface userRepositoryCrudInterface;

    public DataBaseService(UserRepositoryCrudInterface userRepositoryCrudInterface) {
        this.userRepositoryCrudInterface = userRepositoryCrudInterface;
    }

    public Iterable<User> printAllUsers(){
        return userRepositoryCrudInterface.findAll();
    }

    public Iterable<User> printNameParam(String value){
        return userRepositoryCrudInterface.findByName(value);
    }

    public void removeUser(long id){
        userRepositoryCrudInterface.deleteById(id);
    }

    public void addUser(User user){
        userRepositoryCrudInterface.save(user);
    }

    public void updateUser(long id, User user){
        Optional<User> user1 = userRepositoryCrudInterface.findById(id);
        userRepositoryCrudInterface.save(user1.get());
    }



}