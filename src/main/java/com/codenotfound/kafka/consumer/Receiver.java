package com.codenotfound.kafka.consumer;

import java.util.concurrent.CountDownLatch;

import com.codenotfound.kafka.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

public class Receiver {

  private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
  String mno = "${kafka.topic.test123}";

  private CountDownLatch latch = new CountDownLatch(1);

  public CountDownLatch getLatch() {
    return latch;
  }


  @Autowired
  private KafkaTemplate<String,String > kafkaTemplate;


    @KafkaListener(topics = "${kafka.topic.test123}")
  public void receive(String payload) {
    LOGGER.info("received payload='{}'", payload);
    latch.countDown();
  }

  @KafkaListener(topics = "${kafka.topic.cloudNode}")
    public void receive2(String payload){
      System.out.println("${kafka.topic.cloudNode}");
        LOGGER.info("receive payload", payload);
     // String mno = "${kafka.topic.test123}";
      System.out.println(mno);
      kafkaTemplate.send(Config.TEST123,"Acknowledge");
  }

}
