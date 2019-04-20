package com.example.salutem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class sub_running extends AppCompatActivity {

    private EditText runDistanceRunning;
    private EditText runCaloriesRunning;
    private EditText runTimeRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_running);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        runDistanceRunning = (EditText) findViewById(R.id.RunDistanceRunning);
        runCaloriesRunning = (EditText) findViewById(R.id.RunCaloriesRunning);
        runTimeRunning = (EditText) findViewById(R.id.RunTimeRunning);

        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = mPreferences.edit();

        String dist_run = mPreferences.getString(getString(R.string.dist_run), "0");
        String cals_run = mPreferences.getString(getString(R.string.cals_run), "0");
        String time_run = mPreferences.getString(getString(R.string.time_run), "0");

        runDistanceRunning.setText(dist_run);
        runCaloriesRunning.setText(cals_run);
        runTimeRunning.setText(time_run);

        Button btnBackToExercise = (Button) findViewById(R.id.RunningToExercise);

        btnBackToExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString(getString(R.string.dist_run), runDistanceRunning.getText().toString());
                editor.commit();

                editor.putString(getString(R.string.cals_run), runCaloriesRunning.getText().toString());
                editor.commit();

                editor.putString(getString(R.string.time_run), runTimeRunning.getText().toString());
                editor.commit();

                Intent intentBackToExercise = new Intent(sub_running.this, Exercise.class);
                startActivity(intentBackToExercise);
            }
        });
    }

}
