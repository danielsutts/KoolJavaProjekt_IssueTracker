package com.koolJavaProjekts.bugTracker.models;

import javax.persistence.*;

@Entity(name = "users")

public class User {
    @Column
    private final String name;
    @Column
    private final String surname;
    @Column
    private final String nickname;
    @Column
    private final String team;
    @Column
    private final String email;
    @Column
    private final String password;
    @Column
    private final String image;
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
}
