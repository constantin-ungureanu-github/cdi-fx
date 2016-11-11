package org.fx.controller;

import java.util.function.Consumer;

public interface Controller {
    public void setNextCallback(final Consumer<Void> finishCallback);
}
