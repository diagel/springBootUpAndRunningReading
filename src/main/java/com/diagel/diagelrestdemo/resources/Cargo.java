package com.diagel.diagelrestdemo.resources;

import javax.persistence.Entity;
import java.util.UUID;
public class Cargo {
    private final String id;
    private String owner;

    public Cargo() {
        this.id = UUID.randomUUID().toString();
    }

    public Cargo(String owner) {
        this.id = UUID.randomUUID().toString();
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
