package com.classroom.courses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.classroom.R;

import java.util.List;

public class StudentAdapt extends RecyclerView.Adapter<StudentAdapt.ViewHolder> {

    private List<StudentItem> student_name;


    public StudentAdapt(List<StudentItem> student_name) {
        this.student_name = student_name;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_adapt,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        StudentItem studentItem = student_name.get(position);

        holder.student_name.setText(studentItem.getStudentName());


    }

    @Override
    public int getItemCount() {
        return student_name.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView student_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            student_name = itemView.findViewById(R.id.txt_student);
        }
    }
}
