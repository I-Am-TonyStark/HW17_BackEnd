package com.mamalimomen.base.controllers.utilities;

public final class InValidDataException extends Exception {
    public InValidDataException() {
        super("You Entered Wrong Data Format!");
    }

    public InValidDataException(String message) {
        super(message);
    }

    public InValidDataException(Throwable cause) {
        super(cause);

    }

    public InValidDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
