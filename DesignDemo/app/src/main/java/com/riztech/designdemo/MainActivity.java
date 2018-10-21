package com.riztech.designdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtAddress;

    RadioGroup rdgGender;

    RadioButton rdbMale, rdbFemale;

    CheckBox chb10th, chb12th, chbGraduation, chbPG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtAddress = findViewById(R.id.edtAddress);

        rdgGender = findViewById(R.id.rdgGender);

        rdbMale = findViewById(R.id.rdbMale);
        rdbFemale = findViewById(R.id.rdbFemale);

        chb10th = findViewById(R.id.chb10th);
        chb12th = findViewById(R.id.chb12th);
        chbGraduation = findViewById(R.id.chbGraduation);
        chbPG = findViewById(R.id.chbPG);

    }

    public void saveData(View view) {

        String name = edtName.getText().toString().trim();

        String address = edtAddress.getText().toString().trim();

        int checkedRadioButtonId = rdgGender.getCheckedRadioButtonId();

        RadioButton radioButton = findViewById(checkedRadioButtonId);

        String gender = radioButton.getText().toString();

        StringBuilder eduationBuilder = new StringBuilder();

        if(chb10th.isChecked()){
            eduationBuilder.append(chb10th.getText().toString()).append(" ");
        }

        if(chb12th.isChecked()){
            eduationBuilder.append(chb12th.getText().toString()).append(" ");
        }

        if(chbGraduation.isChecked()){
            eduationBuilder.append(chbGraduation.getText().toString()).append(" ");
        }

        if(chbPG.isChecked()){
            eduationBuilder.append(chbPG.getText().toString()).append(" ");
        }

        String education = eduationBuilder.toString();

        StringBuilder finalMessageBuilder = new StringBuilder();

        finalMessageBuilder.append("Name : ").append(name).append("\nAddress : ").append(address)
                .append("\nGender : ").append(gender).append("\nEducation : ").append(education);

        String finalMessage = finalMessageBuilder.toString();

        Toast.makeText(this, finalMessage, Toast.LENGTH_SHORT).show();

    }
}
