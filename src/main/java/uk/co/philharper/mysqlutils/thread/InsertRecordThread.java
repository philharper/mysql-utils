package uk.co.philharper.mysqlutils.thread;

import uk.co.philharper.mysqlutils.connector.Connector;
import uk.co.philharper.mysqlutils.queries.Query;
import uk.co.philharper.mysqlutils.repository.MySQLDatabaseRepository;

public class InsertRecordThread implements Runnable {

    private Connector connector;
    private Query query;

    private MySQLDatabaseRepository mySQLDatabaseRepository;

    public InsertRecordThread(Connector connector, Query query, MySQLDatabaseRepository mySQLDatabaseRepository) {
        this.connector = connector;
        this.query = query;
        this.mySQLDatabaseRepository = mySQLDatabaseRepository;
    }

    @Override
    public void run() {
        mySQLDatabaseRepository.runQuery(query);
    }
}
