package org.example;

public class Items {
    @Id
    private int id;
    private String name;

    public Items() {
    }

    public Items(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return name;
    }

    public void setItemName(String itemName) {
        this.name = itemName;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", itemName='" + name + '\'' +
                '}';
    }
}
