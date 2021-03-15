package com.classroom.courses;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.classroom.R;

import java.util.List;

public class CourseAdapt extends RecyclerView.Adapter<CourseAdapt.MyViewHolder> {


    Activity activity;
    public List<CourseItem> course_name;
    public List<StudentItem> student_name;
    public RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();


    public CourseAdapt(List<CourseItem> courseItemList) {

        this.course_name = courseItemList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_adapt,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        CourseItem courseItem = course_name.get(position);
        holder.course_name_txt.setText(courseItem.getCourseName());

        LinearLayoutManager layoutManager = new LinearLayoutManager(holder.student_name_rv.getContext(), LinearLayoutManager.HORIZONTAL,false);
        layoutManager.setInitialPrefetchItemCount(courseItem.getStudentItemList().size());
        StudentAdapt studentAdapt = new StudentAdapt(courseItem.getStudentItemList());

        holder.student_name_rv.setLayoutManager(layoutManager);
        holder.student_name_rv.setAdapter(studentAdapt);
        holder.student_name_rv.setRecycledViewPool(viewPool);

    }

    @Override
    public int getItemCount() {
        return course_name.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        RecyclerView student_name_rv;
        TextView course_name_txt;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            course_name_txt = itemView.findViewById(R.id.txt_course);
            student_name_rv = itemView.findViewById(R.id.rv_student);


        }
    }
}
