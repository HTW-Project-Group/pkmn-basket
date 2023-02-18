package de.htwberlin.port.exception;

public class BasketWithWrongUserException extends RuntimeException {

  public BasketWithWrongUserException() {
    super("The User for the requested Basket is different than your current User");
  }
}
