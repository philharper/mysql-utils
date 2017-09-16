package uk.co.philharper.mysqlutils.repository;

import uk.co.philharper.mysqlutils.connector.Connector;
import uk.co.philharper.mysqlutils.queries.Query;

import java.sql.*;

public class MySQLDatabaseRepository implements DatabaseRepository {

    Connection conn;
    Statement statement;
    PreparedStatement preparedStatement = null;

    @Override
    public void runQuery(Connector connector, Query query) {
        int i = 1;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + connector.getUrl(), connector.getUsername(), connector.getPassword());

            statement = conn.createStatement();
            preparedStatement = conn.prepareStatement(query.getQuery());

            for (Object obj : query.getParams()) {
                if (obj instanceof String) {
                    preparedStatement.setString(i, (String) obj);
                } else if (obj instanceof Integer) {
                    preparedStatement.setInt(i, (int) obj);
                }
                i++;
            }

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

    }

}
