package com.riztech.sharedprefrence;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void Add(View view) {
        Intent intent = new Intent(this, EmployeeActivity.class);
        startActivity(intent);
    }

    public void View(View view) {
        Intent intent = new Intent(this, ShowEmployeesActivity.class);
        startActivity(intent);
    }

    public void Update(View view) {
    }
}
