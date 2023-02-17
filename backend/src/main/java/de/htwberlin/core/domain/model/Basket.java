package de.htwberlin.core.domain.model;

import java.io.Serializable;
import java.util.List;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Basket implements Serializable {

  private String ownerUserId;

  private List<BasketItem> items;
}
