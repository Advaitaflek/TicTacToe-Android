package com.example.tiktactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PlayerSetup extends AppCompatActivity {

    EditText p1,p2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.player_setup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void submit(View v){
        p1 = findViewById(R.id.editTextText);
        p2 = findViewById(R.id.editTextText2);
        String p1name = p1.getText().toString();
        String p2name = p2.getText().toString();
        if(p1name.isEmpty()){
            Toast.makeText(this, "Enter Player 1 name", Toast.LENGTH_SHORT).show();
        } else if (p2name.isEmpty()) {
            Toast.makeText(this, "Enter Player 2 name", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this, GameDisplay.class);
            intent.putExtra("PLAYER_NAMES", new String[]{p1name, p2name});
            startActivity(intent);
        }

    }
}