package com.waitme.test.web;

import com.waitme.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class SpringRabbitmqTest {

    @Resource(name = "testRabbitTemplate")
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test() {
        System.out.println("rabbitmq send message start...");
        while (true) {
            rabbitTemplate.convertAndSend("rabbitmq test message!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //System.out.println("rabbitmq send message end...");
    }


}
