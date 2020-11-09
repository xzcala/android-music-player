package edu.missouri.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button playButton;
    private Button previousButton;
    private Button nextButton;

    private TextView songInfo;
    private ImageView albumImageView;
    private MediaPlayer mediaPlayer;

    boolean playing = false;

    private int index=0;

    private int[] songs = {
            R.raw.naivety,
            R.raw.la_devotee,
            R.raw.symbolism
    };

    private String[] titles = {
            "A Day To Remember - Naivety",
            "Panic! At the Disco - LA Devotee",
            "Electro-Light - Symbolism"
    };

    private int[] albumCovers = {
            R.drawable.adtr_album,
            R.drawable.panic_album,
            R.drawable.ncs_album
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context = this;

        playButton = findViewById(R.id.playButton);
        previousButton = findViewById(R.id.previousButton);
        nextButton = findViewById(R.id.nextButton);
        songInfo = findViewById(R.id.songInfo);
        albumImageView = findViewById(R.id.albumImageView);

        //previousButton.setEnabled(false);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!playing) {
                    mediaPlayer.start();
                    playButton.setText("Pause");
                    playing = true;
                } else {
                    mediaPlayer.pause();
                    playButton.setText("Play");
                    playing = false;
                }
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if (playing) {
                    mediaPlayer.pause();
                    playButton.setText("Play");
                    playing = false;
                }*/
                //index--;
                //nextButton.setEnabled(true);
                if(index==0)
                    index=2;
                else
                    index--;
                mediaPlayer.stop();
                albumImageView.setImageResource(albumCovers[index]);
                songInfo.setText(titles[index]);
                mediaPlayer = MediaPlayer.create(context, songs[index]);
                mediaPlayer.start();
                playButton.setText("Pause");
                playing = true;
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if (playing) {
                    mediaPlayer.pause();
                    playButton.setText("Play");
                    playing = false;
                }*/
                //index++;
                //previousButton.setEnabled(true);
                if(index==2)
                    index=0;
                else
                    index++;
                //if(index==2)
                //    nextButton.setEnabled(false);
                mediaPlayer.stop();
                albumImageView.setImageResource(albumCovers[index]);
                songInfo.setText(titles[index]);
                mediaPlayer = MediaPlayer.create(context, songs[index]);
                mediaPlayer.start();
                playButton.setText("Pause");
                playing = true;
            }
        });

        albumImageView.setImageResource(albumCovers[index]);
        songInfo.setText(titles[index]);
        mediaPlayer = MediaPlayer.create(context, songs[index]);
    }
}
