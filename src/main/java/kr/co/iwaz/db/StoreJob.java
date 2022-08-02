package kr.co.iwaz.db;

public class StoreJob {

    public StoreJob(String dataCode, String datetime, String value) {
        this.dataCode = dataCode;
        this.datetime = datetime;
        this.value = value;
    }

    String dataCode;
    String datetime;
    String value;
}
