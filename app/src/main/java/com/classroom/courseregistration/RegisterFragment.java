package com.classroom.courseregistration;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.classroom.R;


public class RegisterFragment extends Fragment implements View.OnClickListener {
    EditText lastName;
    EditText studentId;
    Button addStudent;
    Spinner selectCourse;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Add Student");
/*
        lastName=(EditText) getView().findViewById(R.id.student_last_name_edittext);
        studentId=(EditText) getView().findViewById(R.id.student_id_edittext);
        selectCourse=(Spinner) getView().findViewById(R.id.select_course_spinner);
        addStudent=(Button) getView().findViewById(R.id.add_student_btn);
*/
        addStudent.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        checkDataEntered();
    }

    private void checkDataEntered() {
        if(isEmpty(lastName)){
            lastName.setError("Last name is required!");
        }
        if(isEmpty(studentId)){
            studentId.setError("Student Id is required!");
        }
    }

    boolean isEmpty(EditText text){
        CharSequence str=text.getText().toString();
        return TextUtils.isEmpty(str);
    }
}