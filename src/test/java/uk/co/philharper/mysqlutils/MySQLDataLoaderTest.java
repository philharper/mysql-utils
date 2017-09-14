package uk.co.philharper.mysqlutils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class MySQLDataLoaderTest {

    @Test
    public void MySQLDataLoaderBuilderCreatesCorrectObject() {

        String url = "jdbcurl";
        String username = "username";
        String password = "password";

        String query = "NEW QUERY";
        int queryCount = 1;
        Object[] args = new Object[1];

        MySQLDataLoader mySQLDataLoader = new MySQLDataLoader.MySQLDataLoaderBuilder(url, username, password).query(query).queryCount(queryCount).args(args).build();

        assertThat(mySQLDataLoader.getUrl()).isEqualTo(url);
        assertThat(mySQLDataLoader.getUsername()).isEqualTo(username);
        assertThat(mySQLDataLoader.getPassword()).isEqualTo(password);

        assertThat(mySQLDataLoader.getQuery()).isEqualTo(query);
        assertThat(mySQLDataLoader.getArgs()).isEqualTo(args);
        assertThat(mySQLDataLoader.getQueryCount()).isEqualTo(queryCount);
    }

    @Test
    public void MySQLDataLoaderBuilderSetsCountToOneByDefault() {
        String url = "jdbcurl";
        String username = "username";
        String password = "password";

        String query = "NEW QUERY";
        Object[] args = new Object[1];

        MySQLDataLoader mySQLDataLoader = new MySQLDataLoader.MySQLDataLoaderBuilder(url, username, password).query(query).args(args).build();


        assertThat(mySQLDataLoader.getQueryCount()).isEqualTo(1);
    }

}