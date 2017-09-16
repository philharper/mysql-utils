package uk.co.philharper.mysqlutils.repository;

import uk.co.philharper.mysqlutils.connector.Connector;
import uk.co.philharper.mysqlutils.queries.Query;

import java.sql.*;

public class MySQLDatabaseRepository implements DatabaseRepository {

    Connection conn;
    Statement statement;
    PreparedStatement preparedStatement = null;

    public MySQLDatabaseRepository(Connector connector) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + connector.getUrl(), connector.getUsername(), connector.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }

    @Override
    public void runQuery(Query query) {
        try {
            statement = conn.createStatement();
            preparedStatement = conn.prepareStatement(query.getQuery());

            setArguments(query);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

    }

    private void setArguments(Query query) throws SQLException {
        int i = 1;

        for (Object obj : query.getParams()) {
            if (obj instanceof String) {
                preparedStatement.setString(i, (String) obj);
            } else if (obj instanceof Integer) {
                preparedStatement.setInt(i, (int) obj);
            }
            i++;
        }
    }

}
