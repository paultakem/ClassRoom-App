package com.classroom.components;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.classroom.R;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ResultActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_activity);

        EditText sgpa, percentage;

        sgpa = findViewById(R.id.sgpa);
        percentage = findViewById(R.id.percentage);
        TextView t = findViewById(R.id.t);
        TextView t1 = findViewById(R.id.t3);


        try {

            Bundle b = getIntent().getExtras();
            float final_sgpa = b.getFloat("final_sgpa");
            int flag = b.getInt("flag");
            float final_perc = b.getFloat("final_perc");

            if (flag == 0) {
                t.setText("Your CGPA is ");
                percentage.setVisibility(View.INVISIBLE);
                t1.setVisibility(View.INVISIBLE);
            }

            BigDecimal bd = new BigDecimal(final_sgpa).setScale(2, RoundingMode.HALF_EVEN);
            final_sgpa = bd.floatValue();


            BigDecimal bd1 = new BigDecimal(final_perc).setScale(2, RoundingMode.HALF_EVEN);
            final_perc = bd1.floatValue();

            sgpa.setText(String.valueOf(final_sgpa));
            percentage.setText(String.valueOf(final_perc + "%"));
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Exception Occured", Toast.LENGTH_LONG).show();
        }
    }

}