package com.example.comp4020_ui2_prototype;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RewardsActivity extends AppCompatActivity {

    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);
        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}
