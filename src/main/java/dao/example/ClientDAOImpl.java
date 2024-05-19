package dao.example;

import java.sql.Connection;

public class ClientDAOImpl extends AbstractDAO{
    public ClientDAOImpl(Connection conn, String table) {
        super(conn, table);
    }
}
