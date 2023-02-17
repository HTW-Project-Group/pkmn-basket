package de.htwberlin.core.domain.service;

import de.htwberlin.core.domain.model.Basket;
import de.htwberlin.core.domain.model.BasketItem;
import de.htwberlin.core.domain.repository.IBasketRepository;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Transactional
@Validated
@RequiredArgsConstructor
public class BasketService implements IBasketService {

  private final IBasketRepository productRepository;

  @Override
  public BasketItem findBasketItemById(UUID id) {
    return null;
  }

  @Override
  public Basket findBasketByUserId(String userId) {
    return null;
  }

  @Override
  public void addItemToBasketWithUser(BasketItem item, String userId) {}

  @Override
  public void updateItemFromBasketWithUser(BasketItem item, String userId) {}

  @Override
  public void deleteItemFromBasketWithUser(UUID itemId, String userId) {}
}
