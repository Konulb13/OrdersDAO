package dao.example;

import org.example.Clients;
import org.example.Orders;
import org.example.ConnectionFactory;
import org.example.Items;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
 //       Scanner sc = new Scanner(System.in);

        try (Connection conn = ConnectionFactory.getConnection()) {
//            while (true) {
//                System.out.println("if you want to create a new order click 1");
//                System.out.println("if you want to add the order click 2");
//                System.out.println("if you want to see order click 3");
//                System.out.println("if you want to delete the order click 4");
//
//                System.out.println("if you want to create a new client click 5");
//                System.out.println("if you want to add the client click 6");
//                System.out.println("if you want to see client click 7");
//                System.out.println("if you want to delete the client click 8");
//
//                System.out.println("if you want to create a new item click 9");
//                System.out.println("if you want to add the item click 10");
//                System.out.println("if you want to see item click 11");
//                System.out.println("if you want to delete the item click 12");
//                sc.next();
//
//                switch (sc.nextInt()) {
//                    case 1:
//
//
//                }


                //for Clients table
                try {
                    try (Statement stmt = conn.createStatement()) {
                        stmt.execute("DROP TABLE IF EXISTS Clients");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                ClientDAOImpl dao = new ClientDAOImpl(conn, "Clients");
                dao.createTable(Clients.class);
                Clients c = new Clients("Tom", 27);
                dao.add(c);
                List<Clients> clients = dao.getAll(Clients.class);
                for (Clients client : clients) {
                    System.out.println(client);
                    clients.get(0).setAge(28);
                    dao.update(clients.get(0));
                    dao.delete(clients.get(0));
                }

                //for Orders table
                try {
                    try (Statement stmt = conn.createStatement()) {
                        stmt.execute("DROP TABLE IF EXISTS Orders");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                OrdersDAOImpl dao1 = new OrdersDAOImpl(conn, "Orders");
                dao1.createTable(Orders.class);
                Orders o = new Orders(c.getId(), "books", "shipment from Slovakia");
                dao1.add(o);
                List<Orders> orders = dao1.getAll(Orders.class);
                for (Orders order : orders)
                    System.out.println(order);

                dao1.update(orders.get(0));
                dao1.delete(orders.get(0));

                // for Items table
                try {
                    try (Statement stmt = conn.createStatement()) {
                        stmt.execute("DROP TABLE IF EXISTS Items");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                ItemsDAOImpl dao2 = new ItemsDAOImpl(conn, "Items");
                dao2.createTable(Items.class);
                Items i = new Items("book");
                dao2.add(i);
                List<Items> items = dao2.getAll(Items.class);
                for (Items item : items) {
                    System.out.println(item);

                    dao2.update(items.get(0));
                    dao2.delete(items.get(0));
                }
            }
        }
    }