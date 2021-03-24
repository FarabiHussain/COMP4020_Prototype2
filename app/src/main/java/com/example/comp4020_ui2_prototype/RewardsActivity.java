package com.example.comp4020_ui2_prototype;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RewardsActivity extends AppCompatActivity {

    private Button backButton;
    private Button reward1;
    private Button reward2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);
        backButton = findViewById(R.id.backButton);
        reward1 = findViewById(R.id.reward1);
        reward2 = findViewById(R.id.reward2);

        backButton.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });

        reward1.setOnClickListener(v -> {
            reward1.setVisibility(View.INVISIBLE);
            Toast.makeText(RewardsActivity.this, "Reward 1 Redeemed!", Toast.LENGTH_SHORT).show();
        });

        reward2.setOnClickListener(v -> {
            reward2.setVisibility(View.INVISIBLE);
            Toast.makeText(RewardsActivity.this, "Reward 2 Redeemed!", Toast.LENGTH_SHORT).show();
        });
    }
}
