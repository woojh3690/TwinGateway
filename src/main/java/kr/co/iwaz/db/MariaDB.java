package kr.co.iwaz.db;

public class MariaDB extends TwinDB {

    public MariaDB() {
        super();
    }

    @Override
    public void receiveJob(String dataCode, String datetime, String value) {
        String format = "dataCode: %s, datetime: %s, value: %s";
        System.out.printf((format) + "%n", dataCode, datetime, value);
    }
}
