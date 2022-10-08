package pers.fcwy.lab02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import pers.fcwy.lab02.Q2.Person;

@SuppressWarnings("unchecked")
public class Q2_2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q22);

        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));
        rv.setAdapter(
                new ada(
                    (List<Person>) getIntent().getExtras().getSerializable("list"),
                        findViewById(R.id.desc)
                )
        );
    }
}

class vh extends RecyclerView.ViewHolder{
    TextView desc;
    public vh(@NonNull TextView itemView, TextView desc) {
        super(itemView);
        itemView.setLayoutParams(
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT)
        );
        itemView.setTextSize(50);
        this.desc = desc;
    }

    public void bind(Person p){
        ((TextView) itemView).setText(p.getName());
        itemView.setOnClickListener(view->{
            desc.setText(p.toString());
        });
    }
}

class ada extends RecyclerView.Adapter<vh>{

    List<Person> lp;
    TextView desc;

    public ada(List<Person> lp, TextView desc) {
        this.lp = lp;
        this.desc = desc;
    }


    @NonNull
    @Override
    public vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new vh(new TextView(parent.getContext()), desc);
    }

    @Override
    public void onBindViewHolder(@NonNull vh holder, int position) {
        holder.bind(lp.get(position));
    }

    @Override
    public int getItemCount() {
        return lp.size();
    }
}