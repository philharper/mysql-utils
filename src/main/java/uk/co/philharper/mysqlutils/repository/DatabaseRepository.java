package uk.co.philharper.mysqlutils.repository;

public interface DatabaseRepository {

    void runQuery(int queryCount, String query, Object[] args);

}
