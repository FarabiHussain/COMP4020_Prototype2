package com.example.comp4020_ui2_prototype;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SavingsActivity extends AppCompatActivity implements GoalsPopup.PopupListener{

    private Button backButton;
    private Button transferButton;
    private Button createGoalButton;
    private ImageView depositContainer;
    private ImageView savingContainer;
    private ImageView historyContainer;
    private ImageView createGoalContainer;
    private TextView depositText;
    private TextView goalText;
    private TextView savingsText;
    private TextView setupGoalText;
    private TextView historyMonth;
    private TextView historyAmount;
    private TextView savingHistoryHeading;
    private ProgressBar determinateBar;
    private View historyDivider;

    private float savings = 0F;
    private float monthlyDeposit = 0F;
    private float goal = 0F;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings);

        initViews();
        initListeners();
    }

    private void initViews() {
        backButton = findViewById(R.id.backButton);
        transferButton = findViewById(R.id.transferButton);
        createGoalButton = findViewById(R.id.createGoalButton);
        depositContainer = findViewById(R.id.depositContainer);
        savingContainer = findViewById(R.id.savingContainer);
        historyContainer = findViewById(R.id.historyContainer);
        createGoalContainer = findViewById(R.id.createGoalContainer);
        depositText = findViewById(R.id.depositText);
        goalText = findViewById(R.id.goalText);
        savingsText = findViewById(R.id.savingsText);
        setupGoalText = findViewById(R.id.setupGoalText);
        historyMonth = findViewById(R.id.historyMonth);
        historyAmount = findViewById(R.id.historyAmount);
        savingHistoryHeading = findViewById(R.id.savingHistoryHeading);
        determinateBar = findViewById(R.id.determinateBar);
        historyDivider = findViewById(R.id.historyDivider);


        depositContainer.setVisibility(View.INVISIBLE);
        savingContainer.setVisibility(View.INVISIBLE);
        historyContainer.setVisibility(View.INVISIBLE);
        depositText.setVisibility(View.INVISIBLE);
        goalText.setVisibility(View.INVISIBLE);
        savingsText.setVisibility(View.INVISIBLE);
        historyMonth.setVisibility(View.INVISIBLE);
        historyAmount.setVisibility(View.INVISIBLE);
        savingHistoryHeading.setVisibility(View.INVISIBLE);
        transferButton.setVisibility(View.INVISIBLE);
        determinateBar.setVisibility(View.INVISIBLE);
        historyDivider.setVisibility(View.INVISIBLE);
    }

    private void initListeners() {
        backButton.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });

        createGoalButton.setOnClickListener(v -> {
            openGoalsDialog();
        });

        transferButton.setOnClickListener(v -> {

            historyAmount.setText("$"+monthlyDeposit);
            depositText.setText("You have deposited your savings for this month");
            transferButton.setEnabled(false);

            savings += monthlyDeposit;

            savingsText.setText("YOUR CURRENT SAVINGS: $" + savings);
            determinateBar.setProgress(Math.round(goal/savings));

            historyMonth.setVisibility(View.VISIBLE);
            historyAmount.setVisibility(View.VISIBLE);
        });
    }

    private void openGoalsDialog() {
        GoalsPopup goalsPopup = new GoalsPopup();
        goalsPopup.show(getSupportFragmentManager(), "input prompt");
    }

    public void applyGoalsTexts(float amount, int months) {

        depositContainer.setVisibility(View.VISIBLE);
        savingContainer.setVisibility(View.VISIBLE);
        historyContainer.setVisibility(View.VISIBLE);
        depositText.setVisibility(View.VISIBLE);
        goalText.setVisibility(View.VISIBLE);
        savingsText.setVisibility(View.VISIBLE);
        savingHistoryHeading.setVisibility(View.VISIBLE);
        transferButton.setVisibility(View.VISIBLE);
        determinateBar.setVisibility(View.VISIBLE);
        historyDivider.setVisibility(View.VISIBLE);
        createGoalButton.setVisibility(View.INVISIBLE);
        setupGoalText.setVisibility(View.INVISIBLE);
        createGoalContainer.setVisibility(View.INVISIBLE);

        goal = amount;
        goalText.setText("GOAL: $" + goal);
        savingsText.setText("YOUR CURRENT SAVINGS: $" + savings);

        monthlyDeposit = amount/months;
        depositText.setText("You have a pending deposit for $" + monthlyDeposit + " this month");
        /*inputPrimaryBankAccount.setText(account);
        inputPrimaryBankName.setText(name);
        addPrimaryButton.setVisibility(View.INVISIBLE);*/
    }


}
