package de.htwberlin.port.basket;

import de.htwberlin.core.domain.service.IBasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/basket")
@CrossOrigin(origins = "http://localhost:3000")
public class BasketController {

  private final IBasketService productService;
}
