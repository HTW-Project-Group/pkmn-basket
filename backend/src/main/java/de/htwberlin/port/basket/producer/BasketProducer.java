package de.htwberlin.port.basket.producer;

import de.htwberlin.port.dto.CheckoutItemDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class BasketProducer {

  @Value("${queue.exchange}")
  private String exchange;

  @Value("${queue.routing_key}")
  private String routingKey;

  private final RabbitTemplate rabbitTemplate;

  public void sendBasket(List<CheckoutItemDto> basket) {
    log.info(String.format("Basket sent -> %s items", basket.size()));
    rabbitTemplate.convertAndSend(exchange, routingKey, basket);
  }
}
