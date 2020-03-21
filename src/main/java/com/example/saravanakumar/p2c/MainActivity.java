package com.example.saravanakumar.p2c;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    Button encrypt,de;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout layout = new RelativeLayout(this);
        e1=(EditText)findViewById(R.id.t1);
        e2=(EditText)findViewById(R.id.t2);
        e3=(EditText)findViewById(R.id.t3);
        encrypt=(Button)findViewById(R.id.b1);
        de=(Button)findViewById(R.id.b2);
        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String en = e1.getText().toString();
                String key = e3.getText().toString();
                String e = "";
                    en = en.toUpperCase();
                    if (key == null) {
                        Toast.makeText(getApplicationContext(), "Enter Key", Toast.LENGTH_LONG).show();
                    } else {
                        for (int i = 0, j = 0; i < en.length(); i++) {
                            char c = en.charAt(i);
                            if (c < 'A' || c > 'Z') continue;
                            e += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
                            j = ++j % key.length();
                            e2.setText(e);
                        }
                    }


                }

        });
        de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String de = e2.getText().toString();
                String key = e3.getText().toString();
                String d ="";

                de = de.toUpperCase();
                for (int i = 0,j = 0; i < de.length(); i++){
                    char c = de.charAt(i);
                    if (c < 'A' || c > 'Z') continue;
                    d += (char) ((c - key.charAt(j) + 26 * 'A') % 26 + 'A');
                    j = ++j %key.length();
                    e1.setText(d);
                }
            }
        });
    }

}
