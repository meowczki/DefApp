package com.example.aleksandra.defibrylator_linear;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private MediaPlayer mp;

    private ImageButton baed;
    private ImageButton iblad;
    private ImageButton iniewskazana;
    private ImageButton ipik;
    private ImageButton ieleknie;
    private ImageButton iartefakty;
    private ImageButton iekg;
    private ImageButton iwskazana;
    private ImageButton idefibrak;
    private ImageButton idefiok;
    private ImageButton ielekok;
    private ImageButton reset;
    TextView czas;
    long MillisecondTime, StartTime, TimeBuff, UpdateTime = 0L;

    Handler handler;
    // ListView listView ;
//
//    String[] ListElements = new String[] {  };
//
//    List<String> ListElementsArrayList ;
//
//    ArrayAdapter<String> adapter ;
    int Seconds, Minutes, MilliSeconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);
        czas = (TextView) findViewById(R.id.czas);
        baed = (ImageButton) findViewById(R.id.baed);
        iblad = (ImageButton) findViewById(R.id.iblad);
        iwskazana = (ImageButton) findViewById(R.id.wskazana);
        idefibrak = (ImageButton) findViewById(R.id.defi_brak);
        iniewskazana = (ImageButton) findViewById(R.id.niewskazana);
        ipik = (ImageButton) findViewById(R.id.pik);
        ieleknie = (ImageButton) findViewById(R.id.eleknieok);
        iartefakty = (ImageButton) findViewById(R.id.artefakty);
        iekg = (ImageButton) findViewById(R.id.ekg);
        idefiok = (ImageButton) findViewById(R.id.defi_ok);
        ielekok=(ImageButton) findViewById(R.id.elekok);
        reset=(ImageButton) findViewById(R.id.reset);


        handler = new Handler() ;





        iniewskazana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetBackground();
                stopPlaying();

                iniewskazana.setBackgroundColor(Color.argb(100, 91, 203, 191));
                mp = MediaPlayer.create(MainActivity.this, R.raw.niewskazana);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        resetBackground();
                        // finish current activity
                    }
                });
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetBackground();
                stopPlaying();
                handler.removeCallbacks(runnable);
                czas.setText("0:00:00");


            }
        });

        ipik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetBackground();
                stopPlaying();
                ipik.setBackgroundColor(Color.argb(100, 91, 203, 191));
                mp = MediaPlayer.create(MainActivity.this, R.raw.pikpik);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        resetBackground();
                        // finish current activity
                    }
                });
            }
        });

        ieleknie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetBackground();
                stopPlaying();
                ieleknie.setBackgroundColor(Color.argb(100, 91, 203, 191));
                mp = MediaPlayer.create(MainActivity.this, R.raw.eleknieok);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        resetBackground();
                        // finish current activity
                    }
                });
            }
        });


        iartefakty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetBackground();
                stopPlaying();
                iartefakty.setBackgroundColor(Color.argb(100, 91, 203, 191));
                mp = MediaPlayer.create(MainActivity.this, R.raw.artefakty);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        resetBackground();
                        // finish current activity
                    }
                });
            }
        });

        iekg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetBackground();
                stopPlaying();
                iekg.setBackgroundColor(Color.argb(100, 91, 203, 191));
                mp = MediaPlayer.create(MainActivity.this, R.raw.analiza);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        resetBackground();
                        // finish current activity
                    }
                });
            }
        });



        ielekok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetBackground();
                stopPlaying();
                ielekok.setBackgroundColor(Color.argb(100, 91, 203, 191));
                mp = MediaPlayer.create(MainActivity.this, R.raw.analiza);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        resetBackground();
                        // finish current activity
                    }
                });

            }
        });

        idefiok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetBackground();
                stopPlaying();
                idefiok.setBackgroundColor(Color.argb(100, 91, 203, 191));
                mp = MediaPlayer.create(MainActivity.this, R.raw.defiok);


                TimeBuff += MillisecondTime;

                handler.removeCallbacks(runnable);

//                ListElementsArrayList.add(czas.getText().toString());
//
//                adapter.notifyDataSetChanged();

                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        resetBackground();
                        // finish current activity
                    }
                });

            }
        });

        idefibrak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetBackground();
                stopPlaying();
                idefibrak.setBackgroundColor(Color.argb(100, 91, 203, 191));
                mp = MediaPlayer.create(MainActivity.this, R.raw.defibrak);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        resetBackground();
                        // finish current activity
                    }
                });

            }
        });

        iwskazana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetBackground();
                stopPlaying();
                iwskazana.setBackgroundColor(Color.argb(100, 91, 203, 191));
                mp = MediaPlayer.create(MainActivity.this, R.raw.wskazana);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        resetBackground();
                        // finish current activity
                    }
                });
            }
        });
        baed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBackground();
                stopPlaying();
                baed.setBackgroundColor(Color.argb(100, 91, 203, 191));
                mp = MediaPlayer.create(MainActivity.this, R.raw.aed);


                MillisecondTime = 0L ;
                StartTime = 0L ;
                TimeBuff = 0L ;
                UpdateTime = 0L ;
                Seconds = 0 ;
                Minutes = 0 ;
                MilliSeconds = 0 ;

                czas.setText("0:00:00");

                StartTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);


                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                    public void onCompletion(MediaPlayer mp) {
                        resetBackground();
                        // finish current activity
                    }
                });

            }

        });

        iblad.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                resetBackground();
                stopPlaying();
                iblad.setBackgroundColor(Color.argb(100, 91, 203, 191));
                mp = MediaPlayer.create(MainActivity.this, R.raw.blad);
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        resetBackground();
                        // finish current activity
                    }
                });

            }
        });


    }

    private void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;

        }
    }

    private void resetBackground() {
        baed.setBackgroundColor(Color.WHITE);
        iblad.setBackgroundColor(Color.WHITE);
        iwskazana.setBackgroundColor(Color.WHITE);
        idefibrak.setBackgroundColor(Color.WHITE);
        idefiok.setBackgroundColor(Color.WHITE);
        ielekok.setBackgroundColor(Color.WHITE);
        iniewskazana.setBackgroundColor(Color.WHITE);
        ipik.setBackgroundColor(Color.WHITE);
        ieleknie.setBackgroundColor(Color.WHITE);
        iartefakty.setBackgroundColor(Color.WHITE);
        iekg.setBackgroundColor(Color.WHITE);

    }

    public Runnable runnable = new Runnable() {

        public void run() {

            MillisecondTime = SystemClock.uptimeMillis() - StartTime;

            UpdateTime = TimeBuff + MillisecondTime;

            Seconds = (int) (UpdateTime / 1000);

            Minutes = Seconds / 60;

            Seconds = Seconds % 60;

            MilliSeconds = (int) (UpdateTime % 1000);

            czas.setText("" + Minutes + ":"
                    + String.format("%02d", Seconds) + ":"
                    + String.format("%03d", MilliSeconds));

            handler.postDelayed(this, 0);
        }
    };

}







