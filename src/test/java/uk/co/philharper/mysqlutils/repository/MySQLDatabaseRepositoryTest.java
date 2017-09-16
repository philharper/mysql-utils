package uk.co.philharper.mysqlutils.repository;

import org.junit.Test;
import uk.co.philharper.mysqlutils.connector.Connector;
import uk.co.philharper.mysqlutils.queries.Query;

public class MySQLDatabaseRepositoryTest {

    MySQLDatabaseRepository mySQLDatabaseRepository = new MySQLDatabaseRepository();

    @Test
    public void test() {
        Connector connector = new Connector("url", "user", "pass");
        Query query = new Query();

        Object[] objArray = new Object[2];
        objArray[0] = "test";
        objArray[1] = 1;

        query.setQuery("query");
        query.setParams(objArray);

        mySQLDatabaseRepository.runQuery(connector, query);


    }

}