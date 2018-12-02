package com.riztech.sharedprefrence;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EmployeeActivity extends AppCompatActivity {

    EditText edtName, edtDesignation, edtSalary, edtAddress;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        edtName = findViewById(R.id.edtName);
        edtAddress = findViewById(R.id.edtAddress);
        edtSalary = findViewById(R.id.edtSalary);
        edtDesignation = findViewById(R.id.edtDesignation);

        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

                DBHelper dbHelper = new DBHelper(EmployeeActivity.this);
                boolean isInserted = dbHelper.insertImployee(employee);

                if(isInserted){
                    showToast("Record inserted");
                }
                else{
                    showToast("Failed to insert the record");
                }

            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
