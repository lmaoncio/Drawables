package com.example.drawables;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String STATE_SCORE_1 = "score1";
    private static final String STATE_SCORE_2 = "score2";
    int team1Score = 0;
    int team2Score = 0;

    TextView team1TextView;
    TextView team2TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        team1TextView = findViewById(R.id.countTextView);
        team2TextView = findViewById(R.id.countTextView2);

        team1TextView.setText(team1Score+"");
        team2TextView.setText(team2Score+"");

        if (savedInstanceState != null) {
            team1Score = savedInstanceState.getInt(STATE_SCORE_1);
            team2Score = savedInstanceState.getInt(STATE_SCORE_2);
            team1TextView.setText(String.valueOf(team1Score));
            team2TextView.setText(String.valueOf(team2Score));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(STATE_SCORE_1, team1Score);
        outState.putInt(STATE_SCORE_2, team2Score);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.night_mode){
            int nightMode = AppCompatDelegate.getDefaultNightMode();

            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        int nightMode = AppCompatDelegate.getDefaultNightMode();

        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }

        return true;
    }

    public void increaseScoreTeam1(View view) {
        team1Score++;
        team1TextView.setText(team1Score+"");
    }

    public void decreaseScoreTeam1(View view) {
        team1Score--;
        team1TextView.setText(team1Score+"");
    }

    public void increaseScoreTeam2(View view) {
        team2Score++;
        team2TextView.setText(team2Score+"");
    }

    public void decreaseScoreTeam2(View view) {
        team2Score--;
        team2TextView.setText(team2Score+"");
    }
}