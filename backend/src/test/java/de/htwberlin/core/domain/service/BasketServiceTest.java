package de.htwberlin.core.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import de.htwberlin.core.domain.model.BasketFactory;
import de.htwberlin.core.domain.model.BasketItem;
import de.htwberlin.core.domain.repository.BasketInMemoryRepository;
import de.htwberlin.core.domain.repository.IBasketRepository;
import de.htwberlin.port.exception.BasketUserNotFoundException;
import de.htwberlin.port.exception.BasketWithWrongUserException;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasketServiceTest {

  private IBasketService basketService;
  private IBasketRepository basketRepository;

  @BeforeEach
  void setUp() {
    basketRepository = new BasketInMemoryRepository();
    basketService = new BasketService(basketRepository);
  }

  @Test
  void shouldReturnBasketItemById() {
    // given
    final UUID id = UUID.fromString("10000000-0000-0000-0000-000000000000");
    basketRepository.save(BasketFactory.simpleBasketItem().id(id).build());

    // when
    var resultOptional = basketService.findBasketItemById(id);

    // then
    assertThat(resultOptional).isPresent();
    var result = resultOptional.get();
    assertThat(result.getId()).isEqualTo(id);
  }

  @Test
  void shouldFindBasketByUserId() {
    // given
    final UUID userId = UUID.fromString("11111111-0000-0000-0000-000000000000");
    var items =
        List.of(
            BasketFactory.simpleBasketItem()
                .userId(userId)
                .id(UUID.fromString("10000000-0000-0000-0000-000000000000"))
                .build(),
            BasketFactory.simpleBasketItem()
                .userId(userId)
                .id(UUID.fromString("20000000-0000-0000-0000-000000000000"))
                .build());
    basketRepository.save(BasketFactory.simpleBasket(userId).items(items).build());
    final UUID otherUserId = UUID.fromString("22222222-0000-0000-0000-000000000000");
    basketRepository.save(BasketFactory.simpleBasket(otherUserId).build());

    // when
    var result = basketService.findBasketByUserId(userId).getItems();

    // then
    assertThat(result).hasSize(2);
    assertThat(result)
        .extracting(BasketItem::getId)
        .containsExactlyInAnyOrder(
            UUID.fromString("10000000-0000-0000-0000-000000000000"),
            UUID.fromString("20000000-0000-0000-0000-000000000000"));
  }

  @Test
  void shouldThrowErrorWhenFindBasketAndUserIdDoesNotExist() {
    // given
    final UUID otherUserId = UUID.randomUUID();
    basketRepository.save(BasketFactory.simpleBasket(otherUserId).build());

    // when + then
    var id = UUID.randomUUID();
    assertThatThrownBy(() -> basketService.findBasketByUserId(id))
        .isInstanceOf(BasketUserNotFoundException.class);
  }

  @Test
  void shouldAddItemToBasket() {
    // given
    final UUID userId = UUID.fromString("11111111-0000-0000-0000-000000000000");
    final UUID id = UUID.fromString("10000000-0000-0000-0000-000000000000");
    final BasketItem item = BasketFactory.simpleBasketItem().id(id).userId(userId).build();

    // when
    basketService.addItemToBasket(item);
    var resultOptional = basketRepository.findBasketItemById(id);

    // then
    assertThat(resultOptional).isPresent();
    var result = resultOptional.get();
    assertThat(result.getId()).isEqualTo(id);
    assertThat(result.getUserId()).isEqualTo(userId);
  }

  @Test
  void shouldUpdateItemFromBasket() {
    // given
    final UUID id = UUID.fromString("10000000-0000-0000-0000-000000000000");
    var basketItem = BasketFactory.simpleBasketItem().quantity(2).id(id);
    basketRepository.save(basketItem.build());

    // when
    basketService.updateBasketItem(basketItem.quantity(5).build());
    var resultOptional = basketRepository.findBasketItemById(id);

    // then
    assertThat(resultOptional).isPresent();
    var result = resultOptional.get();
    assertThat(result.getId()).isEqualTo(id);
    assertThat(result.getQuantity()).isEqualTo(5);
  }

  @Test
  void shouldThrowErrorWhenUpdateItemFromBasketWithOtherUserThanOwner() {
    // given
    final UUID userId = UUID.randomUUID();
    final UUID id = UUID.randomUUID();
    basketRepository.save(
        BasketFactory.simpleBasketItem().quantity(2).id(id).userId(userId).build());

    // when + then
    var basketItemToUpdate = BasketFactory.simpleBasketItem().id(id).build();
    assertThatThrownBy(() -> basketService.updateBasketItem(basketItemToUpdate))
        .isInstanceOf(BasketWithWrongUserException.class);
  }

  @Test
  void shouldDeleteItemFromBasket() {
    // given
    final UUID id = UUID.fromString("10000000-0000-0000-0000-000000000000");
    basketRepository.save(BasketFactory.simpleBasketItem().id(id).build());

    // when
    basketService.deleteItemFromBasket(id);
    var result = basketRepository.findAll();

    // then
    assertThat(result).isEmpty();
  }
}
