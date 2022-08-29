package com.diagel.diagelrestdemo.resources;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;
@Entity
public class Delivery {
    @Id
    private String id;
    private String number;

    public Delivery() {
        this.id = UUID.randomUUID().toString();
    }

    public Delivery(String id, String number) {
        this.id = id;
        this.number = number;
    }

    public Delivery(String number) {
        this(UUID.randomUUID().toString(), number);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return id.equals(delivery.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
