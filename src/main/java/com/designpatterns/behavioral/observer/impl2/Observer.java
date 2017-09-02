package com.designpatterns.behavioral.observer.impl2;

/**
 * Create Observer class.
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
