package com.company;


import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        String backgroundMusicFilePath = "audio/soundtrack.wav";
       new BackgroundMusic(backgroundMusicFilePath);

        while (true) {
            DungeonGame game = new DungeonGame();
            game.showMainMenu();
        }

    }
}
