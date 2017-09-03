package com.designpatterns.behavioral.observer.g4g;

interface Subject
{
    public void registerObserver(Observer o);
    public void unregisterObserver(Observer o);
    public void notifyObservers();
}

