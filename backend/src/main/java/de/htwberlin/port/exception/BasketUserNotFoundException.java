package de.htwberlin.port.exception;

public class BasketUserNotFoundException extends RuntimeException {

    public BasketUserNotFoundException() {
        super("No user was found for the current basket");
    }
}
