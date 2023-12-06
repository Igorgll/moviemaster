package com.igaogl.moviemaster.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "PERSON")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int userId;

    @NotEmpty(message = "Name cannot be null.")
    @Column(name = "NAME")
    private String name;

    @NotEmpty(message = "Username cannot be null.")
    @Column(name = "USER_NAME")
    private String userName;

    @NotEmpty(message = "Password cannot be null.")
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "PROFILE_PICTURE")
    private String profilePicture;
    // private Collection<Movie> moviesCollection;

    public User() {
    }

    public User(int userId, String name, String userName, String password, String profilePicture) {
        this.userId = userId;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.profilePicture = profilePicture;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
