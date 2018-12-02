package com.riztech.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class StudentListViewHolder extends RecyclerView.ViewHolder {
    TextView txtName, txtClass, txtAddress;
    public StudentListViewHolder(View itemView) {
        super(itemView);
        txtName = itemView.findViewById(R.id.txtName);
        txtAddress = itemView.findViewById(R.id.txtAddress);
        txtClass = itemView.findViewById(R.id.txtClass);
    }
}
