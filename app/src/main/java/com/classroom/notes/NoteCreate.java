package com.classroom.notes;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.classroom.MainMenuActivity;
import com.classroom.R;

public class NoteCreate extends AppCompatActivity {
    EditText title, body;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_create);

        Button btn = findViewById(R.id.noteSaveButton);
        assert btn != null;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        spinner = findViewById(R.id.pinSpinner);
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, MainMenuActivity.divisions);
        assert spinner != null;
        spinner.setAdapter(adapterSpinner);
    }

    private void saveData() {
        title = findViewById(R.id.noteTitle);
        body = findViewById(R.id.noteBody);
        EditText sub = findViewById(R.id.subjectNote);
        String qu = " INSERT INTO NOTES(title,body,cls,sub) VALUES('" + title.getText().toString() + "','" + body.getText().toString() + "'," +
                "'" + spinner.getSelectedItem().toString() + "','" + sub.getText().toString().toUpperCase() + "')";
        if (MainMenuActivity.handler.execAction(qu)) {
            Toast.makeText(getBaseContext(), "Note Saved", Toast.LENGTH_LONG).show();
            this.finish();
        }
    }

}
