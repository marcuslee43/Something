package com.example.administrator.practicetest1;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MediaActivity extends AppCompatActivity {

    Button button1, button2, button3;
    MediaPlayer mediaPlayer;
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        button1= (Button) findViewById(R.id.button8);
        button2= (Button) findViewById(R.id.button9);
        button3= (Button) findViewById(R.id.button10);
        videoView= (VideoView) findViewById(R.id.videoView);


        button2.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.INVISIBLE);
    }

    public void playSong(View view) {
        mediaPlayer = MediaPlayer.create(this, R.raw.keef);
        mediaPlayer.start();
        button1.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);

    }

    public void pauseSong(View view) {

        if(mediaPlayer.isPlaying())
            mediaPlayer.pause();
        else
            mediaPlayer.start();
    }

    public void stopSong(View view) {
        mediaPlayer.stop();
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.INVISIBLE);
    }



    public void playVideo(View view) {
        String uriPath = "android.resource://" + getPackageName() + "/" + R.raw.dbavideo;
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
        videoView.setMediaController(new MediaController(this));
        videoView.start();
        videoView.requestFocus();

    }
}
