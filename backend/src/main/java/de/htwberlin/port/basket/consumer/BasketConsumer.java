package de.htwberlin.port.basket.consumer;

import de.htwberlin.port.dto.ProductExportDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BasketConsumer {

  @RabbitListener(queues = {"product"})
  public void consume(ProductExportDto product) {
    log.info(
        String.format("Received a BasketItem from Product Queue <- %s", product.getPokemonId()));
  }
}
