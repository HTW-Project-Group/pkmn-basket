package de.htwberlin.port.exception;

public class BasketItemNotFoundException extends RuntimeException {
  public BasketItemNotFoundException() {
    super("BasketItem not found");
  }

  public BasketItemNotFoundException(String id) {
    super("BasketItem not found: " + id);
  }
}
