package com.riztech.sharedprefrence;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref;

    Button btnSave;

    EditText edtName, edtAddress, edtPhone;

    private static final String NAME = "name";
    private static final String ADDRESS = "address";
    private static final String PHONE = "phone";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Object creation for shared preference
        pref = getSharedPreferences("Felix", MODE_PRIVATE);

        // View initialization
        edtName = findViewById(R.id.edtName);
        edtAddress = findViewById(R.id.edtAddress);
        edtPhone = findViewById(R.id.edtPhone);
        btnSave = findViewById(R.id.btnSave);

        getPreviouslySavedValue();
    }

    private void getPreviouslySavedValue() {
        String name = pref.getString(NAME, "");
        String address = pref.getString(ADDRESS, "");
        String phone = pref.getString(PHONE, "");
        edtPhone.setText(phone);
        edtAddress.setText(address);
        edtName.setText(name);
    }

    public void Save(View view) {
        String name = edtName.getText().toString().trim();
        String phone = edtPhone.getText().toString().trim();
        String address = edtAddress.getText().toString().trim();

        // Create editor object
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(NAME, name);
        editor.putString(ADDRESS, address);
        editor.putString(PHONE, phone);

        // Commit
        editor.commit();
    }
}
