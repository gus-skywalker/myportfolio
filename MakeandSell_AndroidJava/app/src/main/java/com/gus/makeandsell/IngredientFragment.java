package com.gus.makeandsell;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;


import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */
public class IngredientFragment extends DialogFragment {

    public interface onMultiChoiceListener {
        void onPositiveButtonClicked(String[] list, ArrayList<String> selectedItemList);
        void onNegativeButtonClicked();
    }

    onMultiChoiceListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mListener= (onMultiChoiceListener) context;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassCastException(getActivity().toString()+" onMultiChoiceListener must implemented");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final ArrayList<String> selectedItemList = new ArrayList<>(); // Recebe os items marcados

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final String[] list = getActivity().getResources().getStringArray(R.array.choice_items); // Items a serem selecionados

        builder.setTitle("Select the Items")
                .setMultiChoiceItems(list, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if (b) {
                            selectedItemList.add(list[i]);

                        } else {
                            selectedItemList.remove(list[i]);
                        }
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mListener.onPositiveButtonClicked(list, selectedItemList);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mListener.onNegativeButtonClicked();
                    }
                });
        return builder.create();


    }
}