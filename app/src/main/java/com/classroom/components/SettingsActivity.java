package com.classroom.components;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.Preference;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;

import com.classroom.AppCompatPreferenceActivity;
import com.classroom.MainMenuActivity;
import com.classroom.R;

public class SettingsActivity extends AppCompatPreferenceActivity {
    Activity base = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBar();
        addPreferencesFromResource(R.xml.pref_general);

        Preference myPref = findPreference("clear_schedule");
        myPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(base);
                alert.setTitle("Are you sure ?");
                alert.setMessage("This will wipe your entire scheduling data");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String qu = "DROP TABLE SCHEDULE";
                        if (MainMenuActivity.handler.execAction(qu)) {
                            Toast.makeText(getBaseContext(), "Done", Toast.LENGTH_LONG).show();
                            MainMenuActivity.handler.createTable();
                            dialog.dismiss();
                        }
                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alert.show();
                return true;
            }
        });
        myPref = findPreference("clear_attendance");
        myPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(base);
                alert.setTitle("Are you sure ?");
                alert.setMessage("This will wipe your entire attendance data");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String qu = "DROP TABLE ATTENDANCE";
                        if (MainMenuActivity.handler.execAction(qu)) {
                            Toast.makeText(getBaseContext(), "Done", Toast.LENGTH_LONG).show();
                            MainMenuActivity.handler.createTable();
                            dialog.dismiss();
                        }
                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alert.show();
                return true;
            }
        });

        myPref = findPreference("clear_notes");
        myPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(base);
                alert.setTitle("Are you sure ?");
                alert.setMessage("This will wipe your entire Notes data");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String qu = "DROP TABLE NOTES";
                        if (MainMenuActivity.handler.execAction(qu)) {
                            Toast.makeText(getBaseContext(), "Done", Toast.LENGTH_LONG).show();
                            MainMenuActivity.handler.createTable();
                            dialog.dismiss();
                        }
                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alert.show();
                return true;
            }
        });

        myPref = findPreference("clear_student");
        myPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(base);
                alert.setTitle("Are you sure ?");
                alert.setMessage("This will wipe your entire Student data");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String qu = "DROP TABLE STUDENT";
                        if (MainMenuActivity.handler.execAction(qu)) {
                            Toast.makeText(getBaseContext(), "Done", Toast.LENGTH_LONG).show();
                            MainMenuActivity.handler.createTable();
                            dialog.dismiss();
                        }
                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alert.show();
                return true;
            }
        });
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
