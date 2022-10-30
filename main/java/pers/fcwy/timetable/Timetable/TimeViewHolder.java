package pers.fcwy.timetable.Timetable;

import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TimeViewHolder extends RecyclerView.ViewHolder {
    public TimeViewHolder(@NonNull TextView itemView) {
        super(itemView);
        itemView.setOnClickListener(
                view -> {
                    Toast.makeText(itemView.getContext(), itemView.getText() , Toast.LENGTH_SHORT).show();
                }
        );
    }

    public void setText(String s){
        ((TextView)itemView).setText(s);
    }

    public void disable() {
        itemView.setEnabled(false);
    }
}
