package de.htwberlin.core.domain.repository;

import de.htwberlin.core.domain.model.BasketItem;

import java.util.*;

@SuppressWarnings("NullableProblems")
public class BasketInMemoryRepository extends BaseInMemoryRepository<BasketItem, UUID>
    implements IBasketRepository {

  private final Map<UUID, BasketItem> entities = new HashMap<>();

  @Override
  public Optional<BasketItem> findBasketItemById(UUID id) {
    return Optional.ofNullable(entities.get(id));
  }

  @Override
  public List<BasketItem> findBasketItemsByUserId(UUID userId) {
    return entities.values().stream().filter(b -> b.getUserId().equals(userId)).toList();
  }

  @Override
  public <S extends BasketItem> S save(S entity) {
    entities.put(entity.getId(), entity);
    return entity;
  }

  @Override
  public <S extends BasketItem> List<S> saveAll(Iterable<S> entities) {
    entities.forEach((entity) -> this.entities.put(entity.getId(), entity));
    List<S> result = new ArrayList<>();
    entities.forEach(result::add);
    return result;
  }

  @Override
  public List<BasketItem> findAll() {
    return List.copyOf(entities.values());
  }
}
