package kr.co.iwaz.db;

import java.util.concurrent.LinkedBlockingQueue;

public abstract class TwinDB implements Runnable {

    // 저장 요청 큐. Singleton 패턴을 사용한 변수.
    private static LinkedBlockingQueue<StoreJob> queue = null;

    public TwinDB() {
        if (queue == null)
            queue = new LinkedBlockingQueue<>();
    }

    public void store(StoreJob job) throws InterruptedException {
        queue.put(job);
    }

    @Override
    public void run() {
        try {
            StoreJob job = queue.take();
            receiveJob(job.dataCode, job.datetime, job.value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * DB 에 데이터를 저장한다. 저장할 Job 이 있으면 호출된다.
     * @param dataCode  데이터 구분자
     * @param datetime  데이터 생성시간
     * @param value     데이터
     */
    public abstract void receiveJob(String dataCode, String datetime, String value);
}
