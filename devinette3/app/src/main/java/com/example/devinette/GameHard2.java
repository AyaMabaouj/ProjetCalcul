package com.example.devinette;

import static com.example.devinette.R.id.editText;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class GameHard2 extends AppCompatActivity {

    TextView result;
    EditText nbr = (EditText) findViewById(editText);
    Button valider = findViewById(R.id.valider);
    TextView time;
    Button start_pause;
    TextView score;
    int n = 0;
    String ch = "";
    int scoreR = 100;
    int nbSecondesPasse = 0;
    private  static final long start_time_in_millis = 60000;
    ImageButton restart;
    private CountDownTimer countDownTimer;
    private  boolean mTimerRunning;
    private long mTimeLeftInMiliss = start_time_in_millis;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_hard2);
        result = (TextView) findViewById(R.id.result);
        score = (TextView) findViewById(R.id.score);
        start_pause = findViewById(R.id.start_pause);
        restart = findViewById(R.id.restart);
        time = (TextView)findViewById(R.id.timer);

        int valeur =  (int) (Math.random()*100);


        start_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mTimerRunning){
                    pauseTimer();
                }else{
                    startTimer();
                    nbr.getText().clear();
                    result.setText("");
                }
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });

        updateCountDownText();

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int valeurSaisie = Integer.parseInt((nbr.getText().toString()));
                if (valeur == valeurSaisie){

                    result.setText("Bravo, Vous avez Gagné ! : " +String.valueOf(n)+ " " +"nombres d'essais");
                    countDownTimer.cancel();
                    score.setText("Score : " +(scoreR - (n + nbSecondesPasse)));
                }
                else if (valeurSaisie  > valeur ) {
                    result.setText("Votre nombre est grande !! " );
                    n++;
                    ch+= String.valueOf(valeurSaisie) + " ";
                }

                else {
                    result.setText("Votre nombre est petite !! " );
                    n++;
                    ch+= String.valueOf(valeurSaisie ) + " ";
                }



            }

        });


    }
    private void startTimer(){
        countDownTimer = new CountDownTimer(mTimeLeftInMiliss,1000) {
            @Override
            public void onTick(long milisUntilFinished) {
                mTimeLeftInMiliss = milisUntilFinished;
                updateCountDownText();
                nbSecondesPasse ++;
            }

            @Override
            public void onFinish() {
                time.setText("Vous avez perdu");
                mTimerRunning = false;
                start_pause.setText("start");
                start_pause.setVisibility(View.VISIBLE);
                restart.setVisibility(View.INVISIBLE);
                score.setText("Score :" +(scoreR -(n+ nbSecondesPasse)));

            }
        }.start();
        mTimerRunning = true;
        start_pause.setText("pause");
        restart.setVisibility(View.INVISIBLE);
    }
    private void  pauseTimer(){
        countDownTimer.cancel();
        mTimerRunning = false;
        start_pause.setText("start");
        restart.setVisibility(View.VISIBLE);
    }
    private void resetTimer(){
        mTimeLeftInMiliss = start_time_in_millis;
        updateCountDownText();
        restart.setVisibility(View.INVISIBLE);
        start_pause.setVisibility(View.VISIBLE);
        nbr.getText().clear();
        result.setText("");



    }

    private  void updateCountDownText(){
        int minutes = (int) (mTimeLeftInMiliss / 1000) / 60;
        int seconds = (int) (mTimeLeftInMiliss / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        time.setText(timeLeftFormatted);
    }

}