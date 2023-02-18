package de.htwberlin.core.domain.repository;

import de.htwberlin.core.domain.model.Basket;
import de.htwberlin.core.domain.model.BasketItem;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBasketRepository extends JpaRepository<BasketItem, UUID> {

    Optional<BasketItem> findBasketItemById(UUID id);

    List<BasketItem> findBasketItemsByUserId(UUID userId);

    default void save(Basket entity) {
         this.saveAll(entity.getItems());
    }
}
