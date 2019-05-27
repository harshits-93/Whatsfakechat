package com.example.harsh.whatsfakechat.ui.main;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.harsh.whatsfakechat.R;

public class AppTitleDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //Building an alert Dialog with two buttons Save and Cancel
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Edit App Name");
        Log.d("MYMYMYMYACTIVITY",getActivity().toString());
        LayoutInflater inflater= getActivity().getLayoutInflater();

        final EditText userInput = new EditText(getActivity());
        userInput.setInputType(InputType.TYPE_CLASS_TEXT);
        userInput.setHint(getResources().getString(R.string.app_name));

        builder.setView(inflater.inflate(R.layout.dailog_edit_app_title,null));
//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT);
//        lp.setMargins(8,8,8,8);
//        userInput.setLayoutParams(lp);

        builder.setView(userInput);

        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(TextUtils.isEmpty(userInput.getText().toString().trim())){
                return;
                }
                Log.d("CHECKKINGGGGGGGGGGGGG", userInput.getText().toString().trim());
                getActivity().setTitle(userInput.getText().toString().trim());
                Toast.makeText(getContext(), "App name changed", Toast.LENGTH_SHORT).show();
            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });

        AlertDialog alertDialog = builder.create();

        return alertDialog;
    }


}
