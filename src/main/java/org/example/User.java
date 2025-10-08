package org.example;

public class User {
    private int id;
    private String name;
    private String mail;
    private long age;
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

    public long getId() {
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

    public boolean getIsMan() {
        return isMan;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", age=" + age +
                ", isMan=" + isMan +
                '}';
    }
}