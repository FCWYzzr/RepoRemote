package pers.fcwy.lab03;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class MainActivity extends Activity {

    boolean shift = false, CapsLk = false, filledName = false, filledPswd = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final List<Map<String, String>> al = new ArrayList<>();

        Button btn = findViewById(R.id.button);
        btn.setEnabled(false);
        AtomicReference<Boolean> changed= new AtomicReference<>(false);
        TextView tv = findViewById(R.id.message);

        final EditText name = findViewById(R.id.name);
        name.setOnKeyListener(((view, i, keyEvent) -> {
            if (keyEvent.getAction() == KeyEvent.ACTION_DOWN){
                switch (i){
                    case KeyEvent.KEYCODE_SHIFT_LEFT:
                    case KeyEvent.KEYCODE_SHIFT_RIGHT:
                        shift = true;
                        break;
                    case KeyEvent.KEYCODE_DEL:
                        delete(name);
                        break;
                    case KeyEvent.KEYCODE_CAPS_LOCK:
                        CapsLk = ! CapsLk;
                        break;
                    default:
                        proceedKey4username(name, i);
                }
            }
            else{
                switch (i) {
                    case KeyEvent.KEYCODE_SHIFT_LEFT:
                    case KeyEvent.KEYCODE_SHIFT_RIGHT:
                        shift = false;
                        break;
                }
            }
            filledName = (name.length() > 0);
            btn.setEnabled(filledPswd && filledName);
            return true;
        }));
        final EditText pswd = findViewById(R.id.pswd);
        pswd.setOnKeyListener(((view, i, keyEvent) -> {
                    if (pswd.length()<=5)
                     if (keyEvent.getAction() == KeyEvent.ACTION_DOWN)
                      if (KeyEvent.KEYCODE_0 <= i && i <= KeyEvent.KEYCODE_9)
                          pswd.getText().append(
                                  (char) (i - KeyEvent.KEYCODE_0 + '0')
                          );

                    if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_DEL)
                        delete(pswd);
                    filledPswd = pswd.length() == 6;
                    btn.setEnabled(filledPswd && filledName);
                      return true;
                }));

        btn.setOnClickListener(view->{
            Map<String, String> map = new HashMap<>();
            map.put("name", name.getText().toString());
            map.put("password", pswd.getText().toString());
            al.add(map);
            changed.set(true);
        });

        Thread t = new Thread(()->{
            while (true){
                if (changed.get()){
                    String s = tv.getText().toString();
                    Map<String, String> m = al.get(al.size()-1);
                    tv.setText(String.format(
                            "Get new person: name:%s, password:%s\n%s",
                            m.get("name"), m.get("password"), s
                    ));
                    changed.set(false);
                    name.getText().clear();
                    pswd.getText().clear();
                }

            }
        });
        t.setDaemon(true);
        t.start();
    }

    private void delete(EditText view) {
        if(view.length()>0)
            view.getText().delete(view.length()-1, view.length());
    }

    private void proceedKey4username(EditText view, int i) {
        if (view.length() < 7 &&
                KeyEvent.KEYCODE_A <= i && i <= KeyEvent.KEYCODE_Z){
            view.getText().append(
                    (char)(i - KeyEvent.KEYCODE_A + (shift ^ CapsLk?'A':'a'))
            );
        }
    }


}