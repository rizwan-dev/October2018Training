package com.riztech.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.riztech.recyclerview.data.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentListViewHolder> {
    List<Student> studentList;
    public StudentAdapter(List<Student> studentList){
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_list,null) ;
        return new StudentListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentListViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.txtName.setText("Name : "+student.getName());
        holder.txtAddress.setText("Address : "+student.getAddress());
        holder.txtClass.setText("Class : "+student.getClassName());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }
}
