package de.htwberlin.port.basket.controller;

import de.htwberlin.core.domain.model.Basket;
import de.htwberlin.core.domain.model.BasketItem;
import de.htwberlin.core.domain.service.IBasketService;
import de.htwberlin.port.exception.BasketItemNotFoundException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/basket")
public class BasketController {

  private final IBasketService basketService;

  @GetMapping("/{id}")
  public ResponseEntity<BasketItem> getBasketItem(@PathVariable("id") UUID id) {
    return new ResponseEntity<>(
        basketService.findBasketItemById(id).orElseThrow(BasketItemNotFoundException::new),
        HttpStatus.OK);
  }

  @GetMapping("/user/{userId}")
  public ResponseEntity<Basket> getBasketForUser(@PathVariable("userId") UUID userId) {
    return new ResponseEntity<>(basketService.findBasketByUserId(userId), HttpStatus.OK);
  }

  @PostMapping("/update")
  public ResponseEntity<Basket> updateBasketItemOfBasket(@RequestBody BasketItem basketItem) {
    basketService.updateBasketItem(basketItem);
    return new ResponseEntity<>(
        basketService.findBasketByUserId(basketItem.getUserId()), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Basket> deleteBasketItem(@PathVariable("id") UUID id) {
    final BasketItem basketItem =
        basketService.findBasketItemById(id).orElseThrow(BasketItemNotFoundException::new);
    basketService.deleteItemFromBasket(id);
    return new ResponseEntity<>(
        basketService.findBasketByUserId(basketItem.getUserId()), HttpStatus.OK);
  }
}
