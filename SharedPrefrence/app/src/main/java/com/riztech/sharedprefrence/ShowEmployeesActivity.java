package com.riztech.sharedprefrence;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

public class ShowEmployeesActivity extends AppCompatActivity implements EmployeeClickListener{

    RecyclerView rvEmployess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_employees);

        rvEmployess = findViewById(R.id.rvEmployess);

        DBHelper dbHelper = new DBHelper(this);

        List<Employee> employeeList = dbHelper.getAllEmployees();

        EmployeeListAdapter employeeListAdapter = new EmployeeListAdapter(this,employeeList);

        rvEmployess.setLayoutManager(new LinearLayoutManager(this));

        rvEmployess.setAdapter(employeeListAdapter);

    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemDelete(int position) {

    }
}
