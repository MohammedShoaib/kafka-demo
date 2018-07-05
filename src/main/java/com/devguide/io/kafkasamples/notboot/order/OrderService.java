package com.devguide.io.kafkasamples.notboot.order;

import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 * Author: akhil
 * Created on : 5/7/18
 */
public class OrderService {

  public void processOrder(ConsumerRecord<String, String> order) {
    // do some order processing
    System.out.println(order.toString());
  }

}
