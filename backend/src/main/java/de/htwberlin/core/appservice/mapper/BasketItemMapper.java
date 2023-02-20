package de.htwberlin.core.appservice.mapper;

import de.htwberlin.core.domain.model.BasketItem;
import de.htwberlin.port.dto.BasketItemDto;
import org.springframework.stereotype.Component;

@Component
public class BasketItemMapper implements IBasketItemMapper {

  @Override
  public BasketItem toBasketItem(BasketItemDto dto) {
    return BasketItem.builder()
        .userId(dto.getUserId())
        .pokemonId(dto.getPokemonId())
        .name(dto.getName())
        .description(dto.getDescription())
        .quantity(dto.getQuantity())
        .price(dto.getPrice())
        .build();
  }
}
