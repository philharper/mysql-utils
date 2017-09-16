package uk.co.philharper.mysqlutils.connector;

public class Connector {

    String url;
    String username;
    String password;

    public Connector(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
