package br.com.tayluan.producer.controller;

import br.com.tayluan.producer.dto.OrderDTO;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class ProducerController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public void sendMessage(@RequestBody OrderDTO orderDTO){
        rabbitTemplate.convertAndSend("order.exchange","order",orderDTO);
    }
}
