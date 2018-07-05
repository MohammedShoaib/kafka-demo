package com.devguide.io.kafkasamples.scamazon.web;

import com.devguide.io.kafkasamples.scamazon.event.Producer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * Author: akhil
 * Created on : 5/7/18
 */

@ShellComponent
public class WebService {

  private KafkaTemplate<String, String> kafkaTemplate;

  private static final String ORDER_TOPIC = "ordertopic";

  public WebService()
  {
    kafkaTemplate = new Producer().createTemplate();
    kafkaTemplate.setDefaultTopic(ORDER_TOPIC);
  }


  @ShellMethod("Place an order")
  public void placeOrder(@ShellOption  String product,
                         @ShellOption String customer) {

    // do some webservice logic.
    kafkaTemplate.sendDefault(product, customer);
  }
}
