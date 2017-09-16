package uk.co.philharper.mysqlutils.repository;

import uk.co.philharper.mysqlutils.connector.Connector;
import uk.co.philharper.mysqlutils.queries.Query;

public interface DatabaseRepository {

    void runQuery(Query query);

}
