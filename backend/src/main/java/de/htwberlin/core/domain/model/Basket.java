package de.htwberlin.core.domain.model;

import de.htwberlin.port.exception.BasketUserNotFoundException;
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
    var userId =
        items.stream()
            .map(BasketItem::getUserId)
            .distinct()
            .findFirst()
            .orElseThrow(BasketUserNotFoundException::new);
    return Basket.builder().items(items).userId(userId).build();
  }
}
