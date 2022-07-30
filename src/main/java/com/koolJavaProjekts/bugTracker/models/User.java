package com.koolJavaProjekts.bugTracker.models;

import javax.persistence.*;

@Entity(name = "users")

public class User {
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String nickname;
    @Column
    private String team;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String image;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;


    public User(String name, String surname, String nickname, String team, String email, String password, String image, long id) {
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.team = team;
        this.email = email;
        this.password = password;
        this.image = image;
        this.id = id;
    }

    public User(String email, String password, long id){
        this.email = email;
        this.password = password;
        this.name = "";
        this.surname = "";
        this.nickname = "";
        this.team = "";
        this.image = "";
        this.id = id;
    }

    public User() {
        this.email = "";
        this.password = "";
        this.name = "";
        this.surname = "";
        this.nickname = "";
        this.team = "";
        this.image = "";
        this.id = -1;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getNickname() {
        return nickname;
    }
    public String getTeam() {
        return team;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getImage() {
        return image;
    }
    public long getId() {
        return id;
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setImage(String image) {
        this.image = image;
    }
}

