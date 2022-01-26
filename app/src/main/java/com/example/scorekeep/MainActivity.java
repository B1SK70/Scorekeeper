package com.example.scorekeep;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    private int score1;
    private int score2;
    private TextView score1TextView;
    private TextView score2TextView;
    ImageButton inc1, inc2, dec1, dec2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score1TextView = findViewById(R.id.score_1);
        score2TextView = findViewById(R.id.score_2);

        setButtonsListeners();
        getSavedState(savedInstanceState);
    }

    private void setButtonsListeners() {
        inc1 = findViewById(R.id.increaseTeam1);
        inc2 = findViewById(R.id.increaseTeam2);

        dec1 = findViewById(R.id.decreaseTeam1);
        dec2 = findViewById(R.id.decreaseTeam2);

        inc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score1++;
                rePrintScore();
            }
        });
        inc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score2++;
                rePrintScore();
            }
        });

        // ----------

        dec1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score1--;
                rePrintScore();
            }
        });
        dec2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score2--;
                rePrintScore();
            }
        });
    }

    private void getSavedState(Bundle is) {
        if (is != null) {
            score1 = is.getInt("team1");
            score1TextView.setText(String.valueOf(score1));

            score2 = is.getInt("team2");
            score2TextView.setText(String.valueOf(score2));
        }
    }

    private void rePrintScore() {
        score1TextView.setText(String.valueOf(score1));
        score2TextView.setText(String.valueOf(score2));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("team1", score1);
        outState.putInt("team2", score2);
        super.onSaveInstanceState(outState);
    }

}