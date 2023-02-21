package de.htwberlin.core.domain.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Basket implements Serializable {

  private UUID userId;

  private List<BasketItem> items;

  public static Basket of(List<BasketItem> items) {
    var basket = Basket.builder().items(List.of());
    items.stream()
        .map(BasketItem::getUserId)
        .distinct()
        .findFirst()
        .ifPresent(userId -> basket.items(items).userId(userId));
    return basket.build();
  }
}
