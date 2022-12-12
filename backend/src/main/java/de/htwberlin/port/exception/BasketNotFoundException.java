package de.htwberlin.port.exception;

public class BasketNotFoundException extends RuntimeException {
  public BasketNotFoundException() {
    super("Basket not found");
  }

  public BasketNotFoundException(String id) {
    super("Basket not found: " + id);
  }
}
