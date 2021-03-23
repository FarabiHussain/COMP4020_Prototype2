package com.example.comp4020_ui2_prototype;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AccountsActivity extends AppCompatActivity implements SavingsPopup.PopupListener, PrimaryPopup.PopupListener {

    private Button backButton;
    private Button addPrimaryButton;
    private Button addSavingsButton;
    private TextView inputPrimaryBankName;
    private TextView inputPrimaryBankAccount;
    private TextView inputSavingsBankName;
    private TextView inputSavingsBankAccount;

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
        inputPrimaryBankName = findViewById(R.id.inputPrimaryBankName);
        inputPrimaryBankAccount = findViewById(R.id.inputPrimaryBankAccount);
        inputSavingsBankName = findViewById(R.id.inputSavingsBankName);
        inputSavingsBankAccount = findViewById(R.id.inputSavingsBankAccount);

        initListeners();
    }

    private void initListeners() {
        backButton.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });

        addSavingsButton.setOnClickListener(v -> {
            openSavingsDialog();
        });

        addPrimaryButton.setOnClickListener(v -> {
            openPrimaryDialog();
        });
    }

    private void openPrimaryDialog() {
        PrimaryPopup primaryPopup = new PrimaryPopup();
        primaryPopup.show(getSupportFragmentManager(), "input prompt");
    }

    private void openSavingsDialog() {
        SavingsPopup savingsPopup = new SavingsPopup();
        savingsPopup.show(getSupportFragmentManager(), "input prompt");
    }

    @Override
    public void applyPrimaryTexts(String name, String account) {
        inputPrimaryBankAccount.setText(account);
        inputPrimaryBankName.setText(name);
        addPrimaryButton.setVisibility(View.INVISIBLE);
    }

    public void applySavingsTexts(String name, String account) {
        inputSavingsBankAccount.setText(account);
        inputSavingsBankName.setText(name);
        addSavingsButton.setVisibility(View.INVISIBLE);
    }
}
