package com.riztech.sharedprefrence;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateEmployeeActivity extends AppCompatActivity {

    EditText edtName, edtDesignation, edtSalary, edtAddress;
    int id ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_employee);

        edtName = findViewById(R.id.edtName);
        edtDesignation = findViewById(R.id.edtDesignation);
        edtSalary = findViewById(R.id.edtSalary);
        edtAddress = findViewById(R.id.edtAddress);

        Employee employee = (Employee) getIntent().getSerializableExtra("employee");
        edtName.setText(employee.getName());
        edtAddress.setText(employee.getAddress());
        edtSalary.setText(String.valueOf(employee.getSalary()));
        edtDesignation.setText(employee.getDestination());
        id = employee.getId();

    }

    public void UpdateEmployee(View view) {
        String name = edtName.getText().toString().trim();
        String address = edtAddress.getText().toString().trim();
        String salary = edtSalary.getText().toString().trim();
        String designation = edtDesignation.getText().toString().trim();



        if(TextUtils.isEmpty(name)){
            showToast("Please enter name");
            return;
        }
        if(TextUtils.isEmpty(address)){
            showToast("Please enter address");
            return;
        }
        if(TextUtils.isEmpty(salary)){
            showToast("Please enter salary");
            return;
        }
        if(TextUtils.isEmpty(designation)){
            showToast("Please enter designation");
            return;
        }

        long salaryInNumber = Long.parseLong(salary);

        Employee employee = new Employee(name, designation, salaryInNumber, address);
        employee.setId(id);

        DBHelper dbHelper = new DBHelper(this);

        dbHelper.updateEmployee(employee);


    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
