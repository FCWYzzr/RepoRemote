package pers.fcwy.lab01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import pers.fcwy.lab01.DisplayThings.outputListAdapter;
import pers.fcwy.lab01.RegisterThings.inputListAdapter;

public class Display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Intent from  = getIntent();
        Bundle b = from.getExtras();

        RecyclerView outputList = findViewById(R.id.input_list);
        Button login = findViewById(R.id.login);
        login.setVisibility(View.INVISIBLE);

        outputList.setLayoutManager(
                new LinearLayoutManager(this)
        );

        outputList.setAdapter(
                new outputListAdapter(
                        b
                )
        );
    }
}