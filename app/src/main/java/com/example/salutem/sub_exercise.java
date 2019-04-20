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

public class sub_exercise extends AppCompatActivity {

    private EditText exerciseTimeExercise;
    private EditText exerciseCaloriesExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_exercise);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        exerciseTimeExercise = (EditText) findViewById(R.id.ExerciseTimeExercise);
        exerciseCaloriesExercise = (EditText) findViewById(R.id.ExerciseCaloriesExercise);

        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = mPreferences.edit();

        String time_exe = mPreferences.getString(getString(R.string.time_exe), "0");
        String cals_exe = mPreferences.getString(getString(R.string.cals_exe), "0");

        exerciseTimeExercise.setText(time_exe);
        exerciseCaloriesExercise.setText(cals_exe);

        Button btnBackToExercise = (Button) findViewById(R.id.ExerciseToExercise);

        btnBackToExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString(getString(R.string.time_exe), exerciseTimeExercise.getText().toString());
                editor.commit();

                editor.putString(getString(R.string.cals_exe), exerciseCaloriesExercise.getText().toString());
                editor.commit();

                Intent intentBackToExercise = new Intent(sub_exercise.this, Exercise.class);
                startActivity(intentBackToExercise);
            }
        });
    }

}
