package org.example;

public class Orders {
    @Id
    private int id;
    private int client_id;
    private String name;
    private String order_detail;

    public Orders() {
    }

    public Orders(int client_id, String client_name, String order_detail) {
        this.client_id = client_id;
        this.name = client_name;
        this.order_detail = order_detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getClient_name() {
        return name;
    }

    public void setClient_name(String client_name) {
        this.name = client_name;
    }

    public String getOrder_detail() {
        return order_detail;
    }

    public void setOrder_detail(String order_detail) {
        this.order_detail = order_detail;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", client_id=" + client_id +
                ", client_name='" + name + '\'' +
                ", order_detail='" + order_detail + '\'' +
                '}';
    }

}
