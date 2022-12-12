package de.htwberlin.core.domain.repository;

import de.htwberlin.core.domain.model.Basket;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBasketRepository extends JpaRepository<Basket, UUID> {}
