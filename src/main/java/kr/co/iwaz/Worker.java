package kr.co.iwaz;

import kr.co.iwaz.db.maria.MariaDB;
import kr.co.iwaz.db.StoreJob;
import kr.co.iwaz.db.TwinDB;
import kr.co.iwaz.kafka.KafkaConsumerEZ;
import kr.co.iwaz.thread.ThreadManager;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.Properties;

public class Worker {
    final ThreadManager threadManager;
    final KafkaConsumerEZ kafka;

    public Worker(Properties prop) {
        // 스레드 매니저 초기화
        this.threadManager = new ThreadManager();

        // 카프카 초기화
        KafkaConsumerEZ.Builder builder = new KafkaConsumerEZ.Builder(
                prop.getProperty("KAFKA_IP"),
                Integer.parseInt(prop.getProperty("KAFKA_PORT")))
                .topics(prop.getProperty("KAFKA_TOPIC"))
                .groupName(prop.getProperty("KAFKA_GROUP"));
        this.kafka = new KafkaConsumerEZ(builder);

        // DB 데몬 초기화
        int numOfDBDaemon = Integer.parseInt(prop.getProperty("DB_NUM_OF_DAEMON"));
        for (int i = 0; i < numOfDBDaemon; i++) {
            this.threadManager.newDaemon(new MariaDB(i));
        }
    }

    public void run() throws InterruptedException {
        while (true) {
            for (ConsumerRecord<String, Object> msg : kafka.getRecords()) {
                String value = (String)msg.value();
                // TODO 1 유효성 검사

                // 데이터 저장
                TwinDB.store(new StoreJob("dataCode", "datetime", value));
            }
        }
    }
}
