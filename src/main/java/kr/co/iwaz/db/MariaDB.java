package kr.co.iwaz.db;

public class MariaDB extends TwinDB {
    public final int id;

    public MariaDB(int id) {
        super();
        this.id = id;
    }

    @Override
    public void receiveJob(String dataCode, String datetime, String value) {
        String format = "[ID: %s] dataCode: %s, datetime: %s, value: %s";
        System.out.printf((format) + "%n", id, dataCode, datetime, value);
    }
}
