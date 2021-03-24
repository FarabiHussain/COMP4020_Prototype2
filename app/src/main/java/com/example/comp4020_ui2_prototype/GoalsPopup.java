package com.example.comp4020_ui2_prototype;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

public class GoalsPopup extends AppCompatDialogFragment {
    private EditText goal_amount;
    private EditText goal_duration;
    private GoalsPopup.PopupListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_goal, null);
        builder.setView(view)
                .setNegativeButton("cancel", (dialogInterface, i) -> {

                })
                .setPositiveButton("ok", (dialogInterface, i) -> {
                    float amount;
                    int month;

                    if (TextUtils.isEmpty(goal_duration.getText().toString())) {
                        month = 0;
                    } else {
                        month = Integer.parseInt(goal_duration.getText().toString().trim());
                    }

                    if (TextUtils.isEmpty(goal_amount.getText().toString())) {
                        amount = 0F;
                    } else {
                        amount = Float.parseFloat(goal_amount.getText().toString().trim());
                    }

                    listener.applyGoalsTexts(amount, month);
                });
        goal_amount = view.findViewById(R.id.goal_amount);
        goal_duration = view.findViewById(R.id.goal_duration);
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (GoalsPopup.PopupListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement DialogListener");
        }
    }

    public interface PopupListener {
        void applyGoalsTexts(float amount, int month);
    }
}