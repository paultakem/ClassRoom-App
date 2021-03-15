package com.classroom.courseregistration;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.classroom.R;

public class CourseRegActivity extends AppCompatActivity implements View.OnClickListener{
    EditText lastName;
    EditText studentId;
    Button addStudent;
    Spinner selectCourse;

    private NotificationManagerCompat notificationManager;

    String selectedCourse;
    String[] studentLastName={"Zeid","Ali"};
    int[] studentIdNbr={10,20};
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_register);
        Spinner spinner=(Spinner) findViewById(R.id.select_course_spinner);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(CourseRegActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.pref_sync_frequency_titles)){

            @Override
            public boolean isEnabled(int position) {
                if(position == 0)
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);

                if(position > 0){
                    // Notify the selected item text
                    Toast.makeText
                            (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
                            .show();
                    selectedCourse=selectedItemText;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        notificationManager = NotificationManagerCompat.from(this);
/*
        lastName=(EditText) findViewById(R.id.student_last_name_edittext);
        studentId=(EditText) findViewById(R.id.student_id_edittext);
        selectCourse=(Spinner) findViewById(R.id.select_course_spinner);
        addStudent=(Button) findViewById(R.id.add_student_btn);
*/
        addStudent.setOnClickListener(CourseRegActivity.this);

    }



    @Override
    public void onClick(View v) {
        registerStudent();
    }

    private void registerStudent() {

        if(isEmpty(lastName)){
            lastName.setError("Last name is required!");
        }
        if(isEmpty(studentId)){
            studentId.setError("Student Id is required!");
        }
        if(!isEmpty(lastName) && !isEmpty(studentId)){
            checkDataEntered();
        }

        addNotification();
    }

    boolean isEmpty(EditText text){
        CharSequence str=text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    private void checkDataEntered(){
        String str=lastName.getText().toString();
        int nbr=Integer.parseInt(String.valueOf(studentId.getText()));

        boolean lastNameFinde=false;
        boolean studentidFinde=false;

        for(int i=0;i<studentLastName.length;i++){
            if(nbr==studentIdNbr[i]){
                studentidFinde=true;
                if(str.equals(studentLastName[i])){
                    lastNameFinde=true;
                }
            }
        }

        if(!studentidFinde){
            studentId.setError("Wrong ID!");
            //return;
        }
        if(studentidFinde && !lastNameFinde){
            lastName.setError("The name does not match student ID!");
        }
    }


    public void addNotification(){
        String message="Registration for the course " + selectedCourse;

        Intent intent =new Intent(CourseRegActivity.this,SendNotificationActivity.class);
        PendingIntent pendingIntent =PendingIntent.getActivity(CourseRegActivity.this,0,intent, PendingIntent.FLAG_ONE_SHOT);
        Notification notification = new NotificationCompat.Builder(CourseRegActivity.this, App.CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_message)
                .setContentTitle("New Notification")
                .setContentText(message)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .build();
        notificationManager.notify(1, notification);
    }
}
