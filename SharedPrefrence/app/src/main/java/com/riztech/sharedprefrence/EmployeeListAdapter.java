package com.riztech.sharedprefrence;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListAdapter.EmployeeListViewHolder> {
    List<Employee> employeeList;
    Context context;
    DBHelper dbHelper;

    public EmployeeListAdapter(Context context, List<Employee> employeeList) {
        this.employeeList = employeeList;
        this.context = context;
        dbHelper = new DBHelper(context);
    }

    @NonNull
    @Override
    public EmployeeListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_employee_list, null);
        return new EmployeeListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeListViewHolder employeeListViewHolder, int i) {
        Employee employee = employeeList.get(i);
        employeeListViewHolder.txtName.setText(employee.getName());
        employeeListViewHolder.txtAdress.setText(employee.getAddress());
        employeeListViewHolder.txtDesignation.setText(employee.getDestination());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }


    class EmployeeListViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtDesignation, txtAdress;
        ImageView imgDelete;

         EmployeeListViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAdress = itemView.findViewById(R.id.txtAddress);
            txtName = itemView.findViewById(R.id.txtName);
            txtDesignation = itemView.findViewById(R.id.txtDesignation);
            imgDelete = itemView.findViewById(R.id.imgDelete);

             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     int position = getAdapterPosition();
                     Employee employee = employeeList.get(position);
                     Intent intent = new Intent(context, UpdateEmployeeActivity.class);
                     intent.putExtra("employee", employee);
                     context.startActivity(intent);
                 }
             });

            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Employee employee = employeeList.get(position);
                    boolean isDeleted = dbHelper.deleteEmployee(employee.getId());
                    if (isDeleted) {
                        employeeList.remove(position);
                        notifyDataSetChanged();
                    }
                }
            });
        }
    }

}
