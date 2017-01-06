package com.waitme.spring.autoconfigure.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.Date;

@Configuration
public class RabbitmqConfiguration {

    @Configuration
    protected static class RabbitmqDemoConfiguration {

        @Bean
        public DirectExchange testExchange() {
            return new DirectExchange("testExchange", true, false);
        }

        @Bean
        public Queue testQueue() {
            return new Queue("testQueue", true);
        }

        @Bean
        public Binding myExchangeBinding(@Qualifier("testExchange") DirectExchange directExchange, @Qualifier("testQueue") Queue queue) {
            return BindingBuilder.bind(queue).to(directExchange).with("testRoutingKey");
        }

        @Bean(name = "testRabbitTemplate")
        public RabbitTemplate testRabbitTemplate(ConnectionFactory connectionFactory) {
            RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
            rabbitTemplate.setExchange("testExchange");
            rabbitTemplate.setRoutingKey("testRoutingKey");
            return rabbitTemplate;
        }

        @RabbitListener(queues = "testQueue")
        public void onMessage(@Payload String message){
            System.out.println(">>>>>>>111"+new Date() + ": " + message);
        }

        @RabbitListener(queues = "testQueue")
        public void onMessage1(@Payload String message){
            System.out.println(">>>>>>>222"+new Date() + ": " + message);
        }
    }


}
