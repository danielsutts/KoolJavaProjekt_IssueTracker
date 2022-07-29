package com.koolJavaProjekts.bugTracker.models;

public class User {
    private final String name;
    private final String surname;
    private final String nickname;
    private final String team;
    private final String email;
    private final String password;
    private final String image;
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
