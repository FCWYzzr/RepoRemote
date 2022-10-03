package pers.fcwy.lab01.DisplayThings;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import pers.fcwy.lab01.R;

public class outputListItemViewHolder extends RecyclerView.ViewHolder {

    final private TextView outputHint;
    final private TextView outputText;

    public outputListItemViewHolder(@NonNull View itemView) {
        super(itemView);
        outputHint = itemView.findViewById(R.id.outputHint);
        outputText = itemView.findViewById(R.id.outputText);

    }

    public void setText(String text, String type){
        outputText.setText(text);
        outputHint.setText(type);
    }


}
