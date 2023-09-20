package br.com.tayluan.producer.controller;

import br.com.tayluan.producer.dto.OrderDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order-producer")
public class OrderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${EXCHANGE_NAME}")
    private String exchange;

    @Value("${ROUTING_KEY}")
    private String routingKey;

    @PostMapping
    public void sendMessage(@RequestBody OrderDTO orderDTO){
        rabbitTemplate.convertAndSend(exchange,routingKey,orderDTO);
    }
}
