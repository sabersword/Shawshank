package org.ypq.domain;

import java.io.Serializable;

public class Product implements Serializable {

    private int id;
    private String name;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Product) {
            return (((Product) obj).getId() == id && ((Product) obj).getName().equals(name));
        }
        return false;
    }

    public Product() {
    }

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
