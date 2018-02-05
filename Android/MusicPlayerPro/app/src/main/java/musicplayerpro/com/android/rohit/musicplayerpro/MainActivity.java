package musicplayerpro.com.android.rohit.musicplayerpro;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    ImageView playView;
    ImageView pauseView;

    public void play(View view)
    {
        mediaPlayer.start();
        playView.setAlpha(0f);
        pauseView.setAlpha(1f);
        pauseView.bringToFront();

    }

    public void pause(View view)
    {
        mediaPlayer.pause();
        pauseView.setAlpha(0f);
        playView.setAlpha(1f);
        playView.bringToFront();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playView = findViewById(R.id.play);
        pauseView = findViewById(R.id.pause);

        playView.bringToFront();
        pauseView.setAlpha(0f);

        mediaPlayer = MediaPlayer.create(this, R.raw.demo);

        final SeekBar scrubber = findViewById(R.id.scrubber);

        scrubber.setMax(mediaPlayer.getDuration());

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                scrubber.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0,100);

        scrubber.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if(fromUser)
                {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
