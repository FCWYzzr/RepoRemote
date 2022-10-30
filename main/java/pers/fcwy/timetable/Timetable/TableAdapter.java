package pers.fcwy.timetable.Timetable;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import pers.fcwy.timetable.R;

public class TableAdapter extends RecyclerView.Adapter<TimeViewHolder> {

    List<Schedule> texts;
    String s;
    public boolean shown = false;

    public TableAdapter(List<Schedule> all, boolean O2N) {
        super();
        texts = new LinkedList<>();
        for (Schedule sch :
                all)
            if (sch.filter(O2N))
                texts.add(sch);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.CHINA);
        s = sdf.format(new Date());
    }

    @NonNull
    @Override
    public TimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TimeViewHolder(
                (TextView) View.inflate(parent.getContext(), R.layout.time_item, null)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull TimeViewHolder holder, int position) {
        holder.setText(texts.get(position).toString());

        if (texts.get(position).toString().compareTo(s)<0)
            holder.disable();
        else if (shown){
            shown = true;
            holder.itemView.performClick();
        }
    }

    @Override
    public int getItemCount() {
        return texts.size();
    }



}
