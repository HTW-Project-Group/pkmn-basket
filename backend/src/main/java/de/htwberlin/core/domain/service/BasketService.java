package de.htwberlin.core.domain.service;

import de.htwberlin.core.domain.model.Basket;
import de.htwberlin.core.domain.model.BasketItem;
import de.htwberlin.core.domain.repository.IBasketRepository;
import de.htwberlin.port.exception.BasketWithWrongUserException;
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
    basketRepository.save(item);
  }

  @Override
  public void updateBasketItem(BasketItem item) {
    findBasketItemById(item.getId())
        .ifPresentOrElse(
            basketItem -> {
              if (basketItem.getUserId().equals(item.getUserId())) {
                basketRepository.save(item);
              } else {
                throw new BasketWithWrongUserException();
              }
            },
            () -> addItemToBasket(item));
  }

  @Override
  public void deleteItemFromBasket(UUID itemId) {
    basketRepository.deleteById(itemId);
  }
}
