package com.example.thispring.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "members")
public class User {
    @Id
    private String userId;
    private String password;
    private boolean isActive;

    public User(String userId, boolean isActive, String password) {
        this.userId = userId;
        this.isActive = isActive;
        this.password = password;
    }
    public User(){

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
