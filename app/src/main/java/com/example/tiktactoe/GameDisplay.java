package com.example.tiktactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameDisplay extends AppCompatActivity {

    private TicTacToeBoard ticTacToeBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.game_display);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button playAgain = findViewById(R.id.playAgain);
        Button homebtn = findViewById(R.id.homebtn);
        TextView playerturn = findViewById(R.id.playerdisplay);

        String[] playerName = getIntent().getStringArrayExtra("PLAYER_NAMES");
        if(playerName!= null){
            playerturn.setText((playerName[0]+"'s Turn"));
        }

        playAgain.setVisibility(View.GONE);
        homebtn.setVisibility(View.GONE);

        ticTacToeBoard = findViewById(R.id.ticTacToeBoard);

        ticTacToeBoard.setUpGame(playAgain, homebtn, playerturn, playerName);
    }

    public void playagain(View v){
        ticTacToeBoard.resetGame();
        ticTacToeBoard.invalidate();
    }

    public void home(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}