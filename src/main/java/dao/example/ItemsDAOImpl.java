package dao.example;

import java.sql.Connection;

public class ItemsDAOImpl extends AbstractDAO {
    public ItemsDAOImpl(Connection conn, String table) {
        super(conn, table);
    }
}
