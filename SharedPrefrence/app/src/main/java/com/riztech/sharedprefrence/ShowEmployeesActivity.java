package com.riztech.sharedprefrence;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ShowEmployeesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_employees);

        DBHelper dbHelper = new DBHelper(this);

        List<Employee> employeeList = dbHelper.getAllEmployees();

        for(Employee employee : employeeList){
            showToast("Name : "+ employee.getName() + "\nAddress : "+employee.getAddress());
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
