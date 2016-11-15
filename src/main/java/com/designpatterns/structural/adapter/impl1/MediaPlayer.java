package com.designpatterns.structural.adapter.impl1;

/**
 * Step 1: Create interfaces for Media Player and Advanced Media Player.
 */

public interface MediaPlayer {
    public void play(String audioType, String fileName);
}