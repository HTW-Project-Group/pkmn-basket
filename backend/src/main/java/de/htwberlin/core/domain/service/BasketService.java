package de.htwberlin.core.domain.service;

import de.htwberlin.core.domain.repository.IBasketRepository;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Transactional
@Validated
@RequiredArgsConstructor
public class BasketService implements IBasketService {

  private final IBasketRepository productRepository;
}
