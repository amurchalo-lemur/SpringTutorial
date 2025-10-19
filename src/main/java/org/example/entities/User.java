package org.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "mail")
    private String mail;

    @Column(name = "age")
    private long age;

    @Column(name = "isman")
    private boolean isMan;


    public User() {}

    public User(String name, String mail, long age, boolean isMan) {
        this.name = name;
        this.mail = mail;
        this.age = age;
        this.isMan = isMan;
    }

}