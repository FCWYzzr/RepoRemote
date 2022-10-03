package pers.fcwy.lab01.DisplayThings;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pers.fcwy.lab01.R;

public class outputListAdapter extends RecyclerView.Adapter<outputListItemViewHolder> {

    private final List<String> Key, Value;

    public outputListAdapter(Bundle b) {
        Key = b.getStringArrayList("Keys");
        Value = b.getStringArrayList("Values");
    }

    @NonNull
    @Override
    public outputListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new outputListItemViewHolder(
                View.inflate(
                        parent.getContext(),
                        R.layout.output_list_item,
                        null
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull outputListItemViewHolder holder, int position) {
        holder.setText(Value.get(position), Key.get(position));
    }


    @Override
    public int getItemCount() {
        return Value.size();
    }

}
