package uk.co.philharper.mysqlutils;

import uk.co.philharper.mysqlutils.connector.Connector;
import uk.co.philharper.mysqlutils.queries.Query;
import uk.co.philharper.mysqlutils.repository.MySQLDatabaseRepository;
import uk.co.philharper.mysqlutils.thread.InsertRecordThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MySQLDataLoader {

    private Connector connector;
    private Query query;

    private MySQLDatabaseRepository mySQLDatabaseRepository;

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
        mySQLDatabaseRepository = new MySQLDatabaseRepository(connector);
        mySQLDatabaseRepository.runQuery(query);
    }

    public void insertMultipleRecords() {
        mySQLDatabaseRepository = new MySQLDatabaseRepository(connector);

        ExecutorService pool = Executors.newFixedThreadPool(query.getThreadLimit());

        startThreads(pool);
    }

    private void startThreads(ExecutorService pool) {
        for (int i = query.getCount(); i > 0; i--) {
            InsertRecordThread insertRecordThread = new InsertRecordThread(connector, query, mySQLDatabaseRepository);
            pool.execute(insertRecordThread);
        }

        pool.shutdown();

        try {
            pool.awaitTermination(query.getTimeLimit(), TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
