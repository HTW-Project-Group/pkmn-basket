package de.htwberlin.core.appservice.mapper;

import de.htwberlin.core.domain.model.BasketItem;
import de.htwberlin.port.dto.BasketItemDto;

public interface IBasketItemMapper {

  BasketItem toBasketItem(BasketItemDto dto);
}
