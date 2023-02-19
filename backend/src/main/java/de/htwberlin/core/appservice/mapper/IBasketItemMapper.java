package de.htwberlin.core.appservice.mapper;

import de.htwberlin.core.domain.model.BasketItem;
import de.htwberlin.port.dto.ProductExportDto;

public interface IBasketItemMapper {

  BasketItem toBasketItem(ProductExportDto dto);
}
