package de.htwberlin.core.domain.service;

import de.htwberlin.core.domain.model.Basket;
import de.htwberlin.core.domain.model.BasketItem;
import java.util.UUID;

public interface IBasketService {

  BasketItem findBasketItemById(UUID id);

  Basket findBasketByUserId(UUID userId);

  void addItemToBasketWithUser(BasketItem item, UUID userId);

  void updateItemFromBasketWithUser(BasketItem item, UUID userId);

  void deleteItemFromBasketWithUser(UUID itemId, UUID userId);
}
