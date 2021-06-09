package com.example.pacman;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.pacman.classes.PacMan;
import com.example.pacman.databinding.GameContentBinding;

public class GameContent extends Activity {

    private GameContentBinding binding;
    private MediaPlayer player;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_content);
        setContentView(new PacMan(getApplicationContext()));
        System.out.println("Game Content");
        loadMusic();
    }
    public void   loadMusic (){

        player = MediaPlayer.create(this, R.raw.pacman_song);
        player.setVolume(100, 100);
        player.setLooping(true);
        player.start();

    }
}
