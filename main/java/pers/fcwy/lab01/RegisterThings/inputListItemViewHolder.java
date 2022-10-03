package pers.fcwy.lab01.RegisterThings;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import pers.fcwy.lab01.R;

public class inputListItemViewHolder extends RecyclerView.ViewHolder {

    final private TextView inputHint;
    final private TextInputEditText inputText;

    public inputListItemViewHolder(@NonNull View itemView,
                                   @NonNull inputListAdapter master,
                                   @NonNull InputMethodManager manager) {
        super(itemView);
        inputHint = itemView.findViewById(R.id.inputHint);
        inputText = itemView.findViewById(R.id.input_text);

        inputText.setOnFocusChangeListener(
                (view, focused)->{
                    if(focused) return;
                    inputText.setText(Objects.requireNonNull(
                                    inputText.getText())
                            .toString()
                            .replace("\n",""));

                    System.out.println("Text"+inputText.getText());

                    master.updateAllFilled(
                            Objects.requireNonNull(inputText.getText())
                                    .length()>0,
                            inputHint.getText().toString()
                    );
                }
        );
        inputText.setOnClickListener(
                view->{
                    view.clearFocus();
                    manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
        );

    }

    public void setText(String text){
        inputHint.setText(text);
    }


}
