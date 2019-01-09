package example;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.springframework.kafka.test.rule.EmbeddedKafkaRule;

public final class EmbededKafkaTest {
  @ClassRule
  public static final EmbeddedKafkaRule KAFKA_RULE = new EmbeddedKafkaRule(2, true);

  @Test
  public void example() {
    Assert.assertTrue(true);
  }
}
