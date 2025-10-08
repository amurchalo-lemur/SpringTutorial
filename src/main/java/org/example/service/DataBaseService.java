package org.example.service;

import org.example.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

@Service
public class DataBaseService {
    private final JdbcTemplate jdbcTemplate;

    public DataBaseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> printAllUsers(){
        return jdbcTemplate.query("SELECT * FROM public.user", new BeanPropertyRowMapper<>(User.class));
    }

    public List<User> printNameParam(String value){
        return jdbcTemplate.query("SELECT * FROM public.user WHERE name = ?", new Object[]{value}, new  BeanPropertyRowMapper<>(User.class));
    }

    public void removeUser(int id){
        jdbcTemplate.update("DELETE FROM public.user WHERE id = ?", id);
    }

    public void addUser(User user){///////////
        String sql = "INSERT INTO public.user (name, mail, age, isman) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getMail(), user.getAge(), user.getIsMan());
    }

    public void updateUser(int id, User user){
        jdbcTemplate.update("UPDATE public.user SET name = ?, mail = ? , age = ?, isman = ? WHERE id = ?", user.getName(), user.getMail(), user.getAge(), user.getIsMan(), id);
    }



}