package com.google.sqlite;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddEmployeeActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText id,name,address,salary,job;
    private Button save;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_employee_activity);

        id = findViewById(R.id.id);
        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        salary = findViewById(R.id.salary);
        job = findViewById(R.id.job);

        save = findViewById(R.id.save);
        save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.save){
            Employee employee = new Employee(Integer.parseInt(id.getText().toString()),
                    name.getText().toString(),
                    address.getText().toString(),
                    Double.parseDouble(salary.getText().toString()),
                    job.getText().toString());

            DataBaseHelper helper = new DataBaseHelper(this);
            helper.addEmployee(employee);


        }

    }
}
