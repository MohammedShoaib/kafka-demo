package com.devguide.io.kafkasamples.notboot.order;

import com.devguide.io.kafkasamples.notboot.event.Consumer;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.listener.config.ContainerProperties;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * Author: akhil
 * Created on : 5/7/18
 */
@ShellComponent
public class OrderConsumer {

  private static final String ORDER_TOPIC = "ordertopic";

  private OrderService orderService;

  OrderConsumer()
  {
    orderService = new OrderService();
  }

  @ShellMethod("Run the order service")
  private void startConsumer() {
    ContainerProperties containerProperties = new ContainerProperties(ORDER_TOPIC);
    containerProperties.setMessageListener((MessageListener<String, String>) order -> orderService.processOrder(order));
    KafkaMessageListenerContainer<String, String> container = new Consumer().createContainer(containerProperties);
    container.start();
  }
}
