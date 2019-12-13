package com.boris.img_transformer;

import java.io.IOException;

public class CreateException extends IOException {


    public CreateException() {
    }

    /**
     * An exception who has a message for parameter
     * @param message
     */
    public CreateException(String message) {
        super(message);
    }

    /**
     * An exception who has a message and a cause for parameter
     * @param message
     * @param cause
     */
    public CreateException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * An exception who has a cause for parameter
     * @param cause
     */
    public CreateException(Throwable cause) {
        super(cause);
    }
}
