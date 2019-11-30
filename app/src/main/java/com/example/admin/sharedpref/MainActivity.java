package com.example.admin.sharedpref;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    SharedPreferences preferences;
    EditText uname,upass;
    Button btnlogin,btnshow;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences=getSharedPreferences("myalia",MODE_PRIVATE);

        btnlogin=findViewById(R.id.btnLogin);
        btnshow=findViewById(R.id.btnShow);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                uname=findViewById(R.id.txtName);
                upass=findViewById(R.id.txtPwd);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("name",uname.getText().toString());
                editor.putString("pass",upass.getText().toString());
                editor.commit();

                Toast.makeText(MainActivity.this, "Save Data", Toast.LENGTH_SHORT).show();
                upass.setText("");
                uname.setText("");

            }
        });

        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                preferences=getSharedPreferences("myalia",MODE_PRIVATE);
                uname=findViewById(R.id.txtName);
                upass=findViewById(R.id.txtPwd);
                uname.setText(preferences.getString("name",null));
                upass.setText(preferences.getString("pass",null));
            }
        });
    }

}