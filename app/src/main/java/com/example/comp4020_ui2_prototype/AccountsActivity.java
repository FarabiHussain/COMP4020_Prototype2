package com.example.comp4020_ui2_prototype;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AccountsActivity extends AppCompatActivity {

    private Button backButton;
    private Button addPrimaryButton;
    private Button addSavingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);

        initViews();
    }

    private void initViews() {
        backButton = findViewById(R.id.backButton);
        addPrimaryButton = findViewById(R.id.addPrimaryButton);
        addSavingsButton = findViewById(R.id.addSavingsButton);

        initListeners();
    }

    private void initListeners() {
        backButton.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });

        addSavingsButton.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });

        addPrimaryButton.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}
