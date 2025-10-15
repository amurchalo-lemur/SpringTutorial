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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public void setMan(boolean man) {
        isMan = man;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public long getAge() {
        return age;
    }

    public boolean isMan() {
        return isMan;
    }
}