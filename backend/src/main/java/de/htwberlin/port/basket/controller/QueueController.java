package de.htwberlin.port.basket.controller;

import de.htwberlin.port.basket.producer.BasketProducer;
import de.htwberlin.port.dto.CheckoutItemDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/basket/queue")
public class QueueController {

  private final BasketProducer basketProducer;

  @PostMapping("/checkout/add")
  public void addBasketToCheckoutQueue(@RequestBody List<CheckoutItemDto> checkoutItemDtos) {
    basketProducer.sendBasket(checkoutItemDtos);
  }
}
