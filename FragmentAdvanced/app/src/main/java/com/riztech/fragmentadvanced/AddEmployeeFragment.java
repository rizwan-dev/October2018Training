package com.riztech.fragmentadvanced;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddEmployeeFragment extends Fragment {

    EditText edtName, edtAddress, edtPhone, edtSalary;

    Button btnSave;


    public AddEmployeeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_employee, container, false);
        edtName = view.findViewById(R.id.edtName);
        edtPhone = view.findViewById(R.id.edtPhone);
        edtSalary = view.findViewById(R.id.edtSalary);
        edtAddress = view.findViewById(R.id.edtAddress);

        btnSave = view.findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = edtName.getText().toString().trim();
                String address = edtAddress.getText().toString().trim();
                String phone = edtPhone.getText().toString().trim();
                String salaryString = edtSalary.getText().toString().trim();

                int salary = Integer.parseInt(salaryString);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

                FragmentTransaction transaction = fragmentManager.beginTransaction();

                ShowEmployeeFragment showEmployeeFragment = new ShowEmployeeFragment();

                Bundle bundle = new Bundle();

                bundle.putString("name", name);
                bundle.putString("address", address);
                bundle.putString("phone", phone);
                bundle.putInt("salary", salary);
                showEmployeeFragment.setArguments(bundle);

                transaction.replace(R.id.container, showEmployeeFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }

}
