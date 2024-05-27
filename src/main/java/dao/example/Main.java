package dao.example;
import org.example.Clients;
import org.example.Orders;
import org.example.ConnectionFactory;
import org.example.Items;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = ConnectionFactory.getConnection()) {

            //for Clients table
            try {
                try (Statement stmt = conn.createStatement()) {
                    stmt.execute("DROP TABLE IF EXISTS Clients");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ClientDAOImpl dao = new ClientDAOImpl(conn,"Clients");
            dao.createTable(Clients.class);
            Clients c = new Clients("Tom",27);
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
            OrdersDAOImpl dao1 = new  OrdersDAOImpl(conn,"Orders");
            dao1.createTable(Orders.class);
            Orders o = new Orders(c.getId(),"books","shipment from Slovakia" );
            dao1.add(o);
            List< Orders> orders = dao1.getAll(Orders.class);
            for ( Orders order : orders) {
                System.out.println(order);

                dao1.update(orders.get(0));
                dao1.delete(orders.get(0));
            }


            // for Items table
            try {
                try (Statement stmt = conn.createStatement()) {
                    stmt.execute("DROP TABLE IF EXISTS Items");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ItemsDAOImpl dao2 = new ItemsDAOImpl(conn,"Items");
            dao2.createTable(Items.class);
            Items i = new Items("book" );
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
