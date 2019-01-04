package com.google.sqlite;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class ListEmployeeActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView logout;
    private ListView empList;
    private Button addEmp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_employe_screen);

        logout = findViewById(R.id.logout);
        empList = findViewById(R.id.emp_list);
        addEmp = findViewById(R.id.add_employee);

        logout.setOnClickListener(this);
        addEmp.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.logout){
            SharedPreferences preferences = getSharedPreferences("myAppPref",MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.apply();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }else if(v.getId() == R.id.add_employee){
            Intent intent = new Intent(this,AddEmployeeActivity.class);
            startActivity(intent);
        }

    }
}
