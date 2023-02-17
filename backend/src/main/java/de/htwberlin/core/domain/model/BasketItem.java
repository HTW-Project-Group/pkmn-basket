package de.htwberlin.core.domain.model;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;
import javax.validation.constraints.Min;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "basket")
public class BasketItem implements Serializable {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", nullable = false, updatable = false)
  UUID id;

  @Column(name = "product_id", unique = true, nullable = false, updatable = false)
  String productId;

  @Column(name = "name")
  String name;

  @Column(name = "description")
  String description;

  @Min(1)
  @Column(name = "quantity")
  int quantity;

  @Column(name = "price")
  double price;
}
