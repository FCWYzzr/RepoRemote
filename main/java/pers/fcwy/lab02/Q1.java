package pers.fcwy.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class Q1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1);
        TextInputEditText et = findViewById(R.id.input);
        et.setOnKeyListener((textView, i, keyEvent) -> {
            int kc = keyEvent.getKeyCode(), a = KeyEvent.KEYCODE_A,k = KeyEvent.KEYCODE_K;
            if(keyEvent.getAction() == KeyEvent.ACTION_DOWN){
                et.getText().append((kc >= a && kc <= k)? (char) (kc - a + 'a') :'\0');
                return true;
            }
            return false;
        });
    }
}