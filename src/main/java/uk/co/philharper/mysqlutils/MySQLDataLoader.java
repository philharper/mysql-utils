package uk.co.philharper.mysqlutils;

import uk.co.philharper.mysqlutils.connector.Connector;
import uk.co.philharper.mysqlutils.queries.Query;
import uk.co.philharper.mysqlutils.repository.MySQLDatabaseRepository;

public class MySQLDataLoader {

    private Connector connector;
    private Query query;

    private MySQLDatabaseRepository mySQLDatabaseRepository = new MySQLDatabaseRepository();

    public Connector getConnector() {
        return connector;
    }

    public void setConnector(Connector connector) {
        this.connector = connector;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public void runQuery() {
        mySQLDatabaseRepository.runQuery(connector, query);
    }
}
