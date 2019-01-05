package com.google.sqlite;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView title;
    private EditText username, password;
    private Button login;

    private  boolean isLogged = false;
    private String savedUsername = "ahmed";
    private String savedPassword = "123";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login =findViewById(R.id.login);
        login.setOnClickListener(this);

        SharedPreferences preferences = getSharedPreferences("myAppPref",MODE_PRIVATE);
        isLogged = preferences.getBoolean("isLogged",false);
        if(isLogged == true){
            Intent intent = new Intent(this,ListEmployeeActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.login){
            if(username.getText().toString().equals(savedUsername) && password.getText().toString().equals(savedPassword)){
                Intent intent = new Intent(this,ListEmployeeActivity.class);
                SharedPreferences preferences = getSharedPreferences("myAppPref",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("isLogged",true);
//                editor.commit();
                editor.apply();
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(this,"invalid username or passweord",Toast.LENGTH_SHORT).show();
            }

        }

    }
}
