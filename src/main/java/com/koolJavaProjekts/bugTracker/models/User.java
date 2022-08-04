package com.koolJavaProjekts.bugTracker.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity(name = "users")
public class User implements UserDetails {
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


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

    public User(String email, String password){
        this.email = email;
        this.password = password;
        this.name = "";
        this.surname = "";
        this.nickname = "";
        this.team = "";
        this.image = "";
    }

    public User() {
        this.email = "";
        this.password = "";
        this.name = "";
        this.surname = "";
        this.nickname = "";
        this.team = "";
        this.image = "";
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ADMIN"));
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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
    public void resetUser(User newUser){
        this.name = newUser.name;
        this.surname = newUser.surname;
        this.nickname = newUser.nickname;
        this.email = newUser.email;
        this.password = newUser.password;
        this.image = newUser.image;
        this.team = newUser.team;
    }
}

