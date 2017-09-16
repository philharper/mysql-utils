package uk.co.philharper.mysqlutils;

import uk.co.philharper.mysqlutils.connector.Connector;
import uk.co.philharper.mysqlutils.queries.Query;

public class Main {

    public static void main(String[] args) {
        MySQLDataLoader mySQLDataLoader = new MySQLDataLoader();

        Object[] objectArray = new Object[1];
        objectArray[0] = "HELLO";

        mySQLDataLoader.setQuery(new Query("INSERT INTO test_schema.test_table (name) VALUES (?)", objectArray, 2, 1));
        mySQLDataLoader.setConnector(new Connector("localhost:3306/test_schema", "root", "root"));
        mySQLDataLoader.runQuery();
    }
}
