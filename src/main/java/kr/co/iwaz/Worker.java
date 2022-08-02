package kr.co.iwaz;

import kr.co.iwaz.kafka.KafkaConsumerEZ;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.Properties;

public class Worker {
    final KafkaConsumerEZ kafka;

    public Worker(Properties prop) {
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
