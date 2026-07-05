package com.dharmaraj.exceptions;

public class SameDestinationNotAllowedException extends RuntimeException {

    public SameDestinationNotAllowedException() {
        super("Source and destination cannot be the same.");
    }

}
