package pers.fcwy.lab01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import pers.fcwy.lab01.RegisterThings.inputListAdapter;

public class Register extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final List<String> information = Arrays.asList(
                "姓名 国家（地区） 街道 省（自治区） 市（县） 邮编".split(" ")
        );

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        RecyclerView inputList = findViewById(R.id.input_list);
        Button login = findViewById(R.id.login);

        inputList.setLayoutManager(
                new LinearLayoutManager(this)
        );

        inputList.setAdapter(
                new inputListAdapter(
                    information,
                    login, (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)
                )
        );

        login.setOnClickListener(
                view->{
                    Intent intent = new Intent(this, Display.class);
                    Bundle b = new Bundle();

                    ArrayList<String> al = new ArrayList<>(information.size());
                    for (int i = 0; i < inputList.getChildCount(); i++)
                        al.add(Objects
                                .requireNonNull(((TextInputEditText)
                                inputList.getChildAt(i)
                                .findViewById(R.id.input_text))
                                .getText()).toString());


                    b.putStringArrayList("Values", al);
                    b.putStringArrayList("Keys", new ArrayList<>(information));

                    intent.putExtras(b);
                    startActivity(intent);
        });
    }
}