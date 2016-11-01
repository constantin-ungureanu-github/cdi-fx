package org.fx.transition.implementation;

import org.fx.transition.TransitionEvent;

public class SimpleTransitionEvent implements TransitionEvent {
    private final String message;

    @Override
    public String getMessage() {
        return message;
    }

    public SimpleTransitionEvent(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
