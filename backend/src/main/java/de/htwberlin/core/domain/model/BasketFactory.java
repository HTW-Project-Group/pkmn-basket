package de.htwberlin.core.domain.model;

import com.github.javafaker.Faker;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.NONE)
public class BasketFactory {

  private static final Faker faker = new Faker(Locale.GERMAN);

  public static Basket.BasketBuilder simpleBasket(UUID userId) {
    return Basket.builder()
        .userId(userId)
        .items(
            List.of(
                simpleBasketItem().userId(userId).build(),
                simpleBasketItem().userId(userId).build(),
                simpleBasketItem().userId(userId).build()));
  }

  public static BasketItem.BasketItemBuilder simpleBasketItem() {
    return BasketItem.builder()
        .id(UUID.randomUUID())
        .userId(UUID.randomUUID())
        .name(faker.pokemon().name())
        .price(faker.number().randomDouble(2, 100, 1000))
        .description(faker.lorem().sentence(100))
        .quantity(faker.random().nextInt(1, 10))
        .pokemonId("P" + faker.pokemon().hashCode());
  }
}
