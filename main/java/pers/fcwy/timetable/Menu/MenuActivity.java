package pers.fcwy.timetable.Menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import pers.fcwy.timetable.databinding.ActivityMenuBinding;
import pers.fcwy.timetable.Timetable.timeTableActivity;

public class MenuActivity extends Activity {

    ActivityMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.N2O.setOnClickListener(view -> {
            Intent intent = new Intent(this, timeTableActivity.class);
            intent.putExtra("O2N", true);
            startActivity(intent);
        });
        binding.O2N.setOnClickListener(view -> {
            Intent intent = new Intent(this, timeTableActivity.class);
            intent.putExtra("O2N", false);
            startActivity(intent);
        });
    }

}