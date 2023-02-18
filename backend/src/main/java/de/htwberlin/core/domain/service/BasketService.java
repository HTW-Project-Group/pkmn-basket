package de.htwberlin.core.domain.service;

import de.htwberlin.core.domain.model.Basket;
import de.htwberlin.core.domain.model.BasketItem;
import de.htwberlin.core.domain.repository.IBasketRepository;

import java.util.Optional;
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

  private final IBasketRepository basketRepository;

  @Override
  public Optional<BasketItem> findBasketItemById(UUID id) {
    return basketRepository.findBasketItemById(id);
  }

  @Override
  public Basket findBasketByUserId(UUID userId) {
    return Basket.of(basketRepository.findBasketItemsByUserId(userId));
  }

  @Override
  public void addItemToBasket(BasketItem item) {

  }

  @Override
  public void updateBasketItem(BasketItem item) {

  }

  @Override
  public void deleteItemFromBasket(UUID itemId) {

  }
}
