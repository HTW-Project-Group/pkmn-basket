package de.htwberlin.core.domain.service;

import de.htwberlin.core.domain.model.Basket;
import de.htwberlin.core.domain.model.BasketItem;
import java.util.UUID;

public interface IBasketService {

  BasketItem findBasketItemById(UUID id);

  Basket findBasketByUserId(String userId);

  void addItemToBasketWithUser(BasketItem item, String userId);

  void updateItemFromBasketWithUser(BasketItem item, String userId);

  void deleteItemFromBasketWithUser(UUID itemId, String userId);
}
