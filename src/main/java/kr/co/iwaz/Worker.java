package kr.co.iwaz;

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
    }

    public void run() {
        for (ConsumerRecord<String, Object> msg : kafka.getRecords()) {
            // TODO
        }
    }
}
