package com.example.springwebmvc.model;

import javax.validation.constraints.NotBlank;

public class Jedi {
    @NotBlank
    private String name;
    @NotBlank
    private String lastname;

    public Jedi() {
    }

    public Jedi(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
