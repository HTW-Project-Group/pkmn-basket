package de.htwberlin.port.basket;

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
@CrossOrigin(origins = "http://localhost:3000")
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
}
