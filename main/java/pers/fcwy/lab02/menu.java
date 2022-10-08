package pers.fcwy.lab02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class menu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button b1 = findViewById(R.id.button);
        b1.setOnClickListener(view->
            startActivity(
                    new Intent(this, Q1.class)
            )
        );

        Button b2 = findViewById(R.id.button2);
        b2.setOnClickListener(view->
                startActivity(
                        new Intent(this, Q2_1.class)
                )
        );
    }
}