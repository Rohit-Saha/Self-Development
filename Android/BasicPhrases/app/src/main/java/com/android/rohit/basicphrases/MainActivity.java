package com.android.rohit.basicphrases;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public synchronized void convert(View view)
    {
        int id = view.getId();
        final String myId = view.getResources().getResourceEntryName(id);
        int resourceId = getResources().getIdentifier(myId,"raw", "com.android.rohit.basicphrases");

        MediaPlayer mediaPlayer = MediaPlayer.create(this, resourceId);
        mediaPlayer.start();
        final Button b = (Button)view;
        if(myId.equals("hello"))
        {
            b.setText("Bonjour");
        }
        else if(myId.equals("welcome"))
        {
            b.setText("Bienvenu(e)");
        }
        else if(myId.equals("please"))
        {
            b.setText("S'il vous plaît");
        }
        else if(myId.equals("mynameis"))
        {
            b.setText("Je m'appelle..");
        }
        else if(myId.equals("ilivein"))
        {
            b.setText("J'habite à...");
        }
        else if(myId.equals("howareyou"))
        {
            b.setText("Comment allez-vous");
        }
        else if(myId.equals("goodevening"))
        {
            b.setText("Bonsoir");
        }
        else if(myId.equals("doyouspeakenglish"))
        {
            b.setText("Tu parles anglais");
        }

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
                b.setText(myId);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
