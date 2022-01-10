package com.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Embeddable;

/**
 * @author Ivan Khalopik
 */
//@Entity
@Embeddable
public class User {
    @Id
//    @GeneratedValue
    private int id;
    private String name;
    private String description;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}