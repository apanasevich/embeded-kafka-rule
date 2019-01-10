package example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.springframework.kafka.test.rule.EmbeddedKafkaRule;

import java.util.Collections;

public final class EmbededKafkaTest {
  @ClassRule
  public static final EmbeddedKafkaRule KAFKA_RULE = new EmbeddedKafkaRule(2, true);
  public static final KafkaProducer<String, String> PRODUCER =
      new KafkaProducer<>(Collections.singletonMap(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_RULE.getEmbeddedKafka().getBrokersAsString()),
          new StringSerializer(), new StringSerializer());

  @Test
  public void example() {
    Assert.assertTrue(true);
  }

  @Test
  public void writeToTopic() {
    final String topicName = "whatever";
    KAFKA_RULE.getEmbeddedKafka().addTopics(topicName);
    PRODUCER.send(new ProducerRecord<>(topicName, "key", "value"));
  }
}
