package org.ypq.domain;

public class Product {

    private int id;
    private String name;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Product) {
            return (((Product) obj).getId() == id && ((Product) obj).getName().equals(name));
        }
        return false;
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
