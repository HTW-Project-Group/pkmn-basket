package de.htwberlin.port.basket.consumer;

import de.htwberlin.core.appservice.mapper.IBasketItemMapper;
import de.htwberlin.core.domain.service.IBasketService;
import de.htwberlin.port.dto.ProductExportDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class BasketConsumer {

  private final IBasketService basketService;
  private final IBasketItemMapper basketItemMapper;

  @RabbitListener(queues = {"product"})
  public void consume(ProductExportDto product) {
    log.info(
        String.format("Received a BasketItem from Product Queue <- %s", product.getPokemonId()));

    basketService.addItemToBasket(basketItemMapper.toBasketItem(product));
  }
}
