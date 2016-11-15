package com.designpatterns.structural.adapter.impl1;

/**
 * Step 2: Create concrete classes implementing the AdvancedMediaPlayer interface.
 */

public class MP4Player implements AdvancedMediaPlayer{

    public void playVlc(String fileName) {
        //do nothing
    }

    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}