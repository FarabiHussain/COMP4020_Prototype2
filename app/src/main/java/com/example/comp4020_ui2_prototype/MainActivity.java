package com.example.comp4020_ui2_prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button accountsButton;
    private Button rewardsButton;
    private Button savingsButton;
    private Button profileButton;
    private Button calendarButton;
    private Button statsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews(); // initialises all view elements
    }

    private void initViews() {
        accountsButton = findViewById(R.id.accountsButton);
        rewardsButton = findViewById(R.id.rewardsButton);
        savingsButton = findViewById(R.id.savingButton);
        statsButton = findViewById(R.id.statsButton);
        profileButton = findViewById(R.id.profileButton);
        calendarButton = findViewById(R.id.calendarButton);

        setListeners(); // sets listeners to each view element for navigation between pages
    }

    private void setListeners() {
        accountsButton.setOnClickListener(v -> {
            startActivity(new Intent(this, AccountsActivity.class));
        });

        savingsButton.setOnClickListener(v -> {
            startActivity(new Intent(this, SavingsActivity.class));
        });

        profileButton.setOnClickListener(v -> {
            startActivity(new Intent(this, ProfileActivity.class));
        });

        calendarButton.setOnClickListener(v -> {
            startActivity(new Intent(this, CalendarActivity.class));
        });

        statsButton.setOnClickListener(v -> {
            startActivity(new Intent(this, StatsActivity.class));
        });

        rewardsButton.setOnClickListener(v -> {
            startActivity(new Intent(this, RewardsActivity.class));
        });
    }
}