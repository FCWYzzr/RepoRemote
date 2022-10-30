package pers.fcwy.timetable.Timetable;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import pers.fcwy.timetable.databinding.ActivityTimeTableBinding;

public class timeTableActivity extends Activity {
    private ActivityTimeTableBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTimeTableBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<Schedule> all = Arrays.asList(
                new Schedule(Schedule.Place.Old, Schedule.Place.New, "07:00"),
                new Schedule(Schedule.Place.Mid, Schedule.Place.New, "07:00"),
                new Schedule(Schedule.Place.New, Schedule.Place.Old, "08:30"),
                new Schedule(Schedule.Place.Old, Schedule.Place.New, "09:00"),
                new Schedule(Schedule.Place.New, Schedule.Place.Old, "10:30"),
                new Schedule(Schedule.Place.Old, Schedule.Place.New, "12:30"),
                new Schedule(Schedule.Place.Mid, Schedule.Place.New, "12:30"),
                new Schedule(Schedule.Place.New, Schedule.Place.Old, "13:00"),
                new Schedule(Schedule.Place.Old, Schedule.Place.New, "14:30"),
                new Schedule(Schedule.Place.New, Schedule.Place.Old, "16:00"),
                new Schedule(Schedule.Place.Old, Schedule.Place.New, "17:30"),
                new Schedule(Schedule.Place.New, Schedule.Place.Old, "17:30"),
                new Schedule(Schedule.Place.New, Schedule.Place.Old, "17:30"),
                new Schedule(Schedule.Place.New, Schedule.Place.Old, "18:00"),
                new Schedule(Schedule.Place.New, Schedule.Place.Old, "21:00")
        );
        boolean O2N = getIntent().getBooleanExtra("O2N", false);
        binding.view.setAdapter(
                new TableAdapter(all, O2N)
        );
        binding.view.setLayoutManager(
                new LinearLayoutManager(this)
        );

    }

    @Override
    protected void onResume() {
        super.onResume();
        ((TableAdapter) Objects.requireNonNull(binding.view.
                getAdapter())).shown = false;
    }
}