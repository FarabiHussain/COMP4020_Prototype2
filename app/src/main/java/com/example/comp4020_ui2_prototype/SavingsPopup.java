package com.example.comp4020_ui2_prototype;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

public class SavingsPopup extends AppCompatDialogFragment {
    private EditText editTextSavingsBankName;
    private EditText editTextSavingsBankAccount;
    private SavingsPopup.PopupListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_savings, null);
        builder.setView(view)
                .setNegativeButton("cancel", (dialogInterface, i) -> {

                })
                .setPositiveButton("ok", (dialogInterface, i) -> {
                    String bankName = editTextSavingsBankName.getText().toString();
                    String bankAccount = editTextSavingsBankAccount.getText().toString();
                    listener.applySavingsTexts(bankName, bankAccount);
                });
        editTextSavingsBankName = view.findViewById(R.id.edit_savingsBankName);
        editTextSavingsBankAccount = view.findViewById(R.id.edit_savingsBankAccount);
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (SavingsPopup.PopupListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement DialogListener");
        }
    }

    public interface PopupListener {
        void applySavingsTexts(String name, String account);
    }
}
