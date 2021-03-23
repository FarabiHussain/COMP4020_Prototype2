package com.example.comp4020_ui2_prototype;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity implements UserInfoPopup.PopupListener {

    private Button backButton;
    private Button editButton;
    private TextView userName;
    private TextView userBirthDate;
    private TextView userEmail;
    private TextView userIncome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initViews();
    }

    private void initViews() {
        backButton = findViewById(R.id.backButton);
        editButton = findViewById(R.id.editButton);
        userName = findViewById(R.id.nameInput);
        userBirthDate = findViewById(R.id.birthInput);
        userEmail = findViewById(R.id.emailInput);
        userIncome = findViewById(R.id.incomeInput);

        initListeners();
    }

    private void initListeners() {
        backButton.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });

        editButton.setOnClickListener(v -> {
            openDialog();
        });
    }

    private void openDialog() {
        UserInfoPopup exampleDialog = new UserInfoPopup();
        exampleDialog.show(getSupportFragmentManager(), "input prompt");
    }

    @Override
    public void applyTexts(String name, String birth, String email, String income) {
        userName.setText(name);
        userBirthDate.setText(birth);
        userEmail.setText(email);
        userIncome.setText(income);
    }
}
