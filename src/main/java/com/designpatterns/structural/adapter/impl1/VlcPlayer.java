package com.designpatterns.structural.adapter.impl1;

/**
 * Step 2: Create concrete classes implementing the AdvancedMediaPlayer interface.
 */

public class VlcPlayer implements AdvancedMediaPlayer{

    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    public void playMp4(String fileName) {
        //do nothing
    }
}