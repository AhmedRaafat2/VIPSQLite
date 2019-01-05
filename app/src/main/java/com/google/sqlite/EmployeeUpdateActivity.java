package com.google.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EmployeeUpdateActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView name,address,salary,job;
    private Button update,delete;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_update_delete);

        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        salary = findViewById(R.id.salary);
        job = findViewById(R.id.job);

        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);

        Intent intent = getIntent();
        Employee employee = (Employee) intent.getSerializableExtra("employee");

        name.setText(employee.getName().toString());
        address.setText(employee.getAddress().toString());
        salary.setText(String.valueOf(employee.getSalary()));
        job.setText(employee.getJob().toString());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.update){
            Intent intent = new Intent(this,AddEmployeeActivity.class);
            Intent currentIntent = getIntent();
            Employee employee = (Employee) currentIntent.getSerializableExtra("employee");
            intent.putExtra("employee",employee);
            startActivity(intent);
        }else if(v.getId() == R.id.delete){

            DataBaseHelper helper = new DataBaseHelper(this);
            Employee employee = (Employee) getIntent().getSerializableExtra("employee");
            helper.deleteEmployee(employee.getId());

            Intent intent = new Intent(this,ListEmployeeActivity.class);
            startActivity(intent);
        }
    }
}
