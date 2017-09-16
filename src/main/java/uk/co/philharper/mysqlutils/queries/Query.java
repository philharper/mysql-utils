package uk.co.philharper.mysqlutils.queries;

public class Query {

    String query;
    Object[] params;
    int count;
    int threadLimit;

    public Query(String query, Object[] params, int count, int threadLimit) {
        this.query = query;
        this.params = params;
        this.count = count;
        this.threadLimit = threadLimit;
    }

    public String getQuery() {
        return query;
    }

    public Object[] getParams() {
        return params;
    }

    public int getCount() {
        return count;
    }

    public int getThreadLimit() {
        return threadLimit;
    }
}
