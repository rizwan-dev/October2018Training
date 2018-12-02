package com.riztech.adapterview;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spnCountries;
    AutoCompleteTextView atxtBranch;

    String[] countries =
            {"Select Country", "India", "USA", "Canada", "China", "UK", "Australia", "Japan"};

    String[] branches =
            {"Mechanical", "E&C", "CS", "Civil", "Chemical Engineering", "Agriculture",
                    "Astronomy", "Mechanical"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sf = getSharedPreferences("MyApp",MODE_PRIVATE);

        // Connecting views
        spnCountries = findViewById(R.id.spnCountries);
        atxtBranch = findViewById(R.id.atxtBranch);

        // Creating adapter for country
        ArrayAdapter<String> countryAdpater =
                new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, countries);
        // Setting adapter on spinner
        spnCountries.setAdapter(countryAdpater);


        // Creating adapter for branch
        ArrayAdapter<String> branchAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, branches);
       // Setting adapter on autocomplete textview
        atxtBranch.setAdapter(branchAdapter);
    }
}
