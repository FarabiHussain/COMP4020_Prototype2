package com.example.comp4020_ui2_prototype;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

public class PrimaryPopup extends AppCompatDialogFragment {
    private EditText editTextPrimaryBankName;
    private EditText editTextPrimaryBankAccount;
    private PrimaryPopup.PopupListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_primary, null);
        builder.setView(view)
                .setNegativeButton("cancel", (dialogInterface, i) -> {

                })
                .setPositiveButton("ok", (dialogInterface, i) -> {
                    String bankName = editTextPrimaryBankName.getText().toString();
                    String bankAccount = editTextPrimaryBankAccount.getText().toString();
                    listener.applyPrimaryTexts(bankName, bankAccount);
                });
        editTextPrimaryBankName = view.findViewById(R.id.edit_primaryBankName);
        editTextPrimaryBankAccount = view.findViewById(R.id.edit_primaryBankAccount);
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (PrimaryPopup.PopupListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement DialogListener");
        }
    }

    public interface PopupListener {
        void applyPrimaryTexts(String name, String account);
    }
}
