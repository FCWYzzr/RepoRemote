package pers.fcwy.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.textfield.TextInputEditText;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import pers.fcwy.lab02.Q2.Person;

public class Q2_1 extends Activity {

    private List<Person> ap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ap = new ArrayList<>();
        setContentView(R.layout.activity_q21);
        Button b1 = findViewById(R.id.add),
                b2 = findViewById(R.id.check);
        RadioGroup sex = findViewById(R.id.sex),
                home = findViewById(R.id.home);
        RadioButton defaultSex = findViewById(R.id.male),
                defaultHome = findViewById(R.id.yn);
        CheckBox cb1 = findViewById(R.id.checkBox),
                cb2 = findViewById(R.id.checkBox2),
                cb3 = findViewById(R.id.checkBox3);
        TextInputEditText et = findViewById(R.id.name);
        b1.setEnabled(false);
        et.setOnFocusChangeListener((view, b) -> {
            if (!b){
                b1.setEnabled(!Objects.isNull(et.getText()) &&
                        Objects.requireNonNull(et.getText()).length() > 0);
            }
        });
        et.setOnClickListener(view -> et.clearFocus());

        b1.setOnClickListener(view->{
            Person p = new Person(Objects.requireNonNull(et.getText()).toString(),
                    sex.getCheckedRadioButtonId() == R.id.male,
                    home.getCheckedRadioButtonId() == R.id.yn,
                    new boolean[]{cb1.isChecked(), cb2.isChecked(), cb3.isChecked()}
            );
            if (ap.contains(p)){
                new AlertDialog.Builder(this)
                        .setTitle("人名已存在")
                        .setMessage("请更改")
                        .create()
                        .show();
                et.requestFocus();
            }
            ap.add(p);
            et.getText().clear();
            cb1.setChecked(false);
            cb2.setChecked(false);
            cb3.setChecked(false);
            defaultSex.setChecked(true);
            defaultHome.setChecked(true);
        });

        b2.setOnClickListener(view->{
            Intent i = new Intent(this, Q2_2.class);
            Bundle b = new Bundle();
            b.putSerializable("list", (Serializable) ap);
            i.putExtras(b);
            startActivity(i);
        });
    }
}