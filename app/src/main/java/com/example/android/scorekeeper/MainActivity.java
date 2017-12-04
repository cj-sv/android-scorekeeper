package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int serveTeamA = 0;
    int serveTeamB = 0;

    //Player who score 11 first wins. When players are tied before 11, max score is increased by 1.
    int maxScore = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Checks if players are tied 1 point under winning score. If so, winning score increases by 1.
    public void checkIfTie () {
        if (scoreTeamA == (maxScore - 1) && scoreTeamB == (maxScore - 1)) {
            maxScore = maxScore + 1;
        }
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void onePointTeamA (View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);

        checkIfTie();

        if (scoreTeamA == maxScore) {
            displayWinForTeamA();
        }
    }

    /**
     * Displays the given serve for Team A.
     */
    public void displayServeForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_serves);
        scoreView.setText(String.valueOf(score));
    }

    public void oneServeTeamA (View v) {
        serveTeamA = serveTeamA + 1;
        displayServeForTeamA(serveTeamA);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void onePointTeamB (View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);

        checkIfTie();

        if (scoreTeamB == maxScore) {
            displayWinForTeamB();
        }
    }

    /**
     * Displays the given serve for Team B.
     */
    public void displayServeForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_serves);
        scoreView.setText(String.valueOf(score));
    }

    public void oneServeTeamB (View v) {
        serveTeamB = serveTeamB + 1;
        displayServeForTeamB(serveTeamB);
    }

    /**
     * Displays if Team A wins.
     */
    public void displayWinForTeamA() {
        TextView message = (TextView) findViewById(R.id.team_a_win);
        message.setText("WINNER");
    }

    /**
     * Displays if Team B wins.
     */
    public void displayWinForTeamB() {
        TextView message = (TextView) findViewById(R.id.team_b_win);
        message.setText("WINNER");
    }


    /**
     * Resets scores and serves for both teams.
     */
    public void resetScores(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);

        serveTeamA = 0;
        serveTeamB = 0;
        displayServeForTeamA(serveTeamA);
        displayServeForTeamB(serveTeamB);

        maxScore = 11;

        TextView messageA = (TextView) findViewById(R.id.team_a_win);
        messageA.setText("");

        TextView messageB = (TextView) findViewById(R.id.team_b_win);
        messageB.setText("");
    }
}
