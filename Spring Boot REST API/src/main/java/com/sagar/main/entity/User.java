package com.sagar.main.entity;

import javax.persistence.*;

@Entity
@Table(
        name = "users"
)
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    private String fname;
    private String lname;
    private String email;
    private String password;

    public User() {
    }

    public int getId() {
        return this.id;
    }

    public String getFname() {
        return this.fname;
    }

    public String getLname() {
        return this.lname;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public void setFname(final String fname) {
        this.fname = fname;
    }

    public void setLname(final String lname) {
        this.lname = lname;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
