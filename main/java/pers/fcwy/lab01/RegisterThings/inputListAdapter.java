package pers.fcwy.lab01.RegisterThings;

import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pers.fcwy.lab01.R;

public class inputListAdapter extends RecyclerView.Adapter<inputListItemViewHolder> {

    private final List<String> hints;

    private Map<String, Boolean> map;

    final private Button btn;
    final private InputMethodManager manager;

    public inputListAdapter(List<String> hints, Button btn, InputMethodManager manager) {
        this.hints = hints;
        this.btn = btn;
        this.manager = manager;
        map = new HashMap<>();
        for (String hint : hints)
            map.put(hint, false);
    }

    @NonNull
    @Override
    public inputListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new inputListItemViewHolder(
                View.inflate(
                        parent.getContext(),
                        R.layout.input_list_item,
                        null
                ),
                this,
                manager
        );
    }

    @Override
    public void onBindViewHolder(@NonNull inputListItemViewHolder holder, int position) {
        holder.setText(hints.get(position));
    }


    @Override
    public int getItemCount() {
        return hints.size();
    }

    public void updateAllFilled(boolean filled, String type){
        map.put(type,filled);
        boolean B = true;
        for (boolean b :
                map.values())
            B &= b;
        btn.setEnabled(B);
    }

}
