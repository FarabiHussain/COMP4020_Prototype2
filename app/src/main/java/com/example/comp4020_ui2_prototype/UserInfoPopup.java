package com.example.comp4020_ui2_prototype;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

public class UserInfoPopup extends AppCompatDialogFragment {
    private EditText editTextUserName;
    private EditText editTextUserBirthDate;
    private EditText editTextUserEmail;
    private EditText editTextUserIncome;
    private PopupListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_user, null);
        builder.setView(view)
                .setNegativeButton("cancel", (dialogInterface, i) -> {
                })
                .setPositiveButton("ok", (dialogInterface, i) -> {
                    String userName = editTextUserName.getText().toString();
                    String birthDate = editTextUserBirthDate.getText().toString();
                    String userEmail = editTextUserEmail.getText().toString();
                    String userIncome = editTextUserIncome.getText().toString();
                    listener.applyTexts(userName, birthDate, userEmail, userIncome);
                });
        editTextUserName = view.findViewById(R.id.edit_userName);
        editTextUserBirthDate = view.findViewById(R.id.edit_userBirthDate);
        editTextUserEmail = view.findViewById(R.id.edit_userEmail);
        editTextUserIncome = view.findViewById(R.id.edit_userIncome);
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (PopupListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement DialogListener");
        }
    }

    public interface PopupListener {
        void applyTexts(String userName, String birthDate, String userEmail, String userIncome);
    }
}
