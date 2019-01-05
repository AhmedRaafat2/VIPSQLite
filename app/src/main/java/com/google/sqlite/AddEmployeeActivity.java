package com.google.sqlite;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddEmployeeActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText id, name, address, salary, job;
    private Button save;
    private Employee employee;

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
        Intent intent = getIntent();
        employee = (Employee) intent.getSerializableExtra("employee");

        if (employee != null) {
            id.setText(String.valueOf(employee.getId()));
            name.setText(employee.getName());
            address.setText(employee.getAddress());
            salary.setText(String.valueOf(employee.getSalary()));
            job.setText(employee.getJob());
        }
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.save) {

            if (employee == null) {
                Employee employee = new Employee(Integer.parseInt(id.getText().toString()),
                        name.getText().toString(),
                        address.getText().toString(),
                        Double.parseDouble(salary.getText().toString()),
                        job.getText().toString());

                DataBaseHelper helper = new DataBaseHelper(this);
                helper.addEmployee(employee);

                Intent intent = new Intent(this, ListEmployeeActivity.class);
                startActivity(intent);
            } else if (employee != null) {

                Employee employee = new Employee(Integer.parseInt(id.getText().toString()),
                        name.getText().toString(),
                        address.getText().toString(),
                        Double.parseDouble(salary.getText().toString()),
                        job.getText().toString());

                DataBaseHelper helper = new DataBaseHelper(this);
                helper.updateEmployee(employee);

                Intent intent = new Intent(this, ListEmployeeActivity.class);
                startActivity(intent);

            }

        }

    }
}
