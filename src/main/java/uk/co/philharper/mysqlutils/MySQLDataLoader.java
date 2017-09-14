package uk.co.philharper.mysqlutils;

import uk.co.philharper.mysqlutils.repository.DatabaseRepository;
import uk.co.philharper.mysqlutils.repository.MySQLDatabaseRepository;

public class MySQLDataLoader implements DataLoader {

    private DatabaseRepository databaseRepository = new MySQLDatabaseRepository();

    private final String url;
    private final String username;
    private final String password;

    private String query;
    private int queryCount;
    private Object args[];

    private MySQLDataLoader(MySQLDataLoaderBuilder mySQLDataLoaderBuilder) {
        this.url = mySQLDataLoaderBuilder.url;
        this.username = mySQLDataLoaderBuilder.username;
        this.password = mySQLDataLoaderBuilder.password;

        this.query = mySQLDataLoaderBuilder.query;
        this.queryCount = mySQLDataLoaderBuilder.queryCount;
        this.args = mySQLDataLoaderBuilder.args;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getQuery() {
        return this.query;
    }

    public Object[] getArgs() {
        return this.args;
    }

    public int getQueryCount() {
        return this.queryCount;
    }

    public static class MySQLDataLoaderBuilder {
        private final String url;
        private final String username;
        private final String password;

        private String query;
        private int queryCount = 1;
        private Object args[];

        public MySQLDataLoaderBuilder(String url, String username, String password) {
            this.url = url;
            this.username = username;
            this.password = password;
        }

        public MySQLDataLoaderBuilder query(String query) {
            this.query = query;
            return this;
        }

        public MySQLDataLoaderBuilder queryCount(int queryCount) {
            this.queryCount = queryCount;
            return this;
        }

        public MySQLDataLoaderBuilder args(Object... args) {
            this.args = args;
            return this;
        }

        public MySQLDataLoader build() {
            return new MySQLDataLoader(this);
        }
    }

    @Override
    public void insertMultipleRecords() {
        databaseRepository.runQuery(queryCount, query, args);
    }

}
