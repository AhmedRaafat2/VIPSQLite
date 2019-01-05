package com.google.sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EmployeeAdapter extends ArrayAdapter<Employee> {

    private Context context;
    private ArrayList<Employee> employees;
    private TextView id,name,address,salary,job;

    public EmployeeAdapter(Context context, ArrayList<Employee> employees) {
        super(context, R.layout.custom_row, employees);
        this.context = context;
        this.employees = employees;
    }

    @Override
    public int getCount() {
        return employees.size();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.custom_row,null);

        id = view.findViewById(R.id.id_preview);
        name = view.findViewById(R.id.name_preview);
        address = view.findViewById(R.id.address_preview);
        salary = view.findViewById(R.id.salary_preview);
        job = view.findViewById(R.id.job_preview);

        //هنا استخدمنا ميثود من جوا كلاس استرنج
        //اسمها فاليو اوف علشان احول من القيمة الانتجر او اى قيمة
        //الى قيمة استرنج
        id.setText(String.valueOf(employees.get(position).getId()));
        name.setText(employees.get(position).getName());
        address.setText(employees.get(position).getAddress());
        salary.setText(String.valueOf(employees.get(position).getSalary()));
        job.setText(employees.get(position).getJob());

        return view;
    }
}
