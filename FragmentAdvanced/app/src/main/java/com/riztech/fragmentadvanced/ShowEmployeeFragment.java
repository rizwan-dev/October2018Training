package com.riztech.fragmentadvanced;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowEmployeeFragment extends Fragment {

    TextView txtName, txtAddress, txtPhone, txtSalary;

    Button btnBack;


    public ShowEmployeeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_employee, container, false);

        txtAddress = view.findViewById(R.id.txtAddress);
        txtName = view.findViewById(R.id.txtName);
        txtPhone = view.findViewById(R.id.txtPhone);
        txtSalary = view.findViewById(R.id.txtSalary);
        btnBack = view.findViewById(R.id.btnBack);
        Bundle bundle = getArguments();

        String name = bundle.getString("name");
        String address = bundle.getString("address");
        String phone = bundle.getString("phone");
        int salary = bundle.getInt("salary");

        txtName.setText(name);
        txtAddress.setText(address);
        txtPhone.setText(phone);
        txtSalary.setText(String.valueOf(salary));
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        return view;
    }

}
