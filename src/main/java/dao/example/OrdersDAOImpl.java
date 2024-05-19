package dao.example;

import java.sql.Connection;

public class OrdersDAOImpl extends AbstractDAO{
    public OrdersDAOImpl(Connection conn, String table) {
        super(conn, table);
    }
}
