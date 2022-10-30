package pers.fcwy.timetable.Timetable;

import androidx.annotation.NonNull;

import java.util.Locale;

public class Schedule implements Comparable<Schedule> {
    final private String beg, end;
    final private String t_beg;

    public Schedule(String beg, String end, String t_beg) {
        this.beg = beg;
        this.end = end;
        this.t_beg = t_beg;
    }

    @NonNull
    @Override
    public String toString() {
        return String.format(Locale.CHINA,
                "%s\t%s --- %s", t_beg, beg, end);
    }

    @Override
    public int compareTo(Schedule schedule) {
        return t_beg.equals(schedule.t_beg)?
                beg.compareTo(schedule.beg):
                t_beg.compareTo(schedule.t_beg);
    }



    public boolean filter(boolean O2N){
        return O2N == end.equals(Place.Old);
    }


    public interface Place{
        String New = "呈贡",
        Old = "东陆",
        Mid = "龙泉小区";
    }
}
