package de.htwberlin.core.domain.service;

import de.htwberlin.core.domain.model.Basket;
import de.htwberlin.core.domain.model.BasketItem;
import java.util.Optional;
import java.util.UUID;

public interface IBasketService {

  Optional<BasketItem> findBasketItemById(UUID id);

  Basket findBasketByUserId(UUID userId);

  void addItemToBasket(BasketItem item);

  void updateBasketItem(BasketItem item);

  void deleteItemFromBasket(UUID itemId);
}
