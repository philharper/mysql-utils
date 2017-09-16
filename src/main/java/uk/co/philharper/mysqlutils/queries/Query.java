package uk.co.philharper.mysqlutils.queries;

public class Query {

    String query;
    Object[] params;
    int count;
    int threadLimit;
    int timeLimit;

    public Query(String query, Object[] params, int count, int threadLimit, int timeLimit) {
        this.query = query;
        this.params = params;
        this.count = count;
        this.threadLimit = threadLimit;
        this.timeLimit = timeLimit;
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

    public int getTimeLimit() {
        return timeLimit;
    }
}
