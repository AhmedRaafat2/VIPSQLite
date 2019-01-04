package com.google.sqlite;

public class Employee {

    private String name,address,job;
    private  int id;
    private  double salary;

    public Employee(int id, String name, String address, double salary, String job) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.job = job;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", job='" + job + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }
}
