package com.example.salutem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Exercise extends AppCompatActivity {

    private TextView distanceRunning;
    private TextView caloriesRunning;
    private TextView timeExercise;
    private TextView caloriesExercise;
    private TextView distanceBiking;
    private TextView caloriesBiking;
    private TextView totalCaloriesBurned;
    private TextView totalMinutesExercised;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        distanceRunning = (TextView) findViewById(R.id.DistanceRunning);
        caloriesRunning = (TextView) findViewById(R.id.CaloriesRunning);
        timeExercise = (TextView) findViewById(R.id.TimeExercise);
        caloriesExercise = (TextView) findViewById(R.id.CaloriesExercise);
        distanceBiking = (TextView) findViewById(R.id.DistanceBiking);
        caloriesBiking = (TextView) findViewById(R.id.CaloriesBiking);
        totalCaloriesBurned = (TextView) findViewById(R.id.TotalCaloriesBurned);
        totalMinutesExercised = (TextView) findViewById(R.id.TotalMinutesExercised);

        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mPreferences.edit();

        String dist_run = mPreferences.getString(getString(R.string.dist_run), "0");
        String cals_run = mPreferences.getString(getString(R.string.cals_run), "0");
        String time_run = mPreferences.getString(getString(R.string.time_run), "0");
        String time_exe = mPreferences.getString(getString(R.string.time_exe), "0");
        String cals_exe = mPreferences.getString(getString(R.string.cals_exe), "0");
        String dist_bik = mPreferences.getString(getString(R.string.dist_bik), "0");
        String cals_bik = mPreferences.getString(getString(R.string.cals_bik), "0");
        String time_bik = mPreferences.getString(getString(R.string.time_bik), "0");

        distanceRunning.setText(dist_run);
        caloriesRunning.setText(cals_run);
        timeExercise.setText(time_exe);
        caloriesExercise.setText(cals_exe);
        distanceBiking.setText(dist_bik);
        caloriesBiking.setText(cals_bik);

        int int_cals_run = Integer.parseInt(cals_run);
        int int_cals_exe = Integer.parseInt(cals_exe);
        int int_cals_bik = Integer.parseInt(cals_bik);
        int total_cals = int_cals_run + int_cals_exe + int_cals_bik;
        editor.putString(getString(R.string.total_cals_burned), Integer.toString(total_cals));
        editor.commit();
        totalCaloriesBurned.setText(Integer.toString(total_cals));

        int int_time_run = Integer.parseInt(time_run);
        int int_time_exe = Integer.parseInt(time_exe);
        int int_time_bik = Integer.parseInt(time_bik);
        int total_time = int_time_run + int_time_exe + int_time_bik;
        editor.putString(getString(R.string.total_mins_exe), Integer.toString(total_time));
        editor.commit();
        totalMinutesExercised.setText(Integer.toString(total_time));

        Button btnEditRunning = (Button) findViewById(R.id.edit_running);
        Button btnEditExercise = (Button) findViewById(R.id.edit_exercise);
        Button btnEditBiking = (Button) findViewById(R.id.edit_biking);
        Button btnProfile = (Button) findViewById(R.id.ExerciseToProfile);
        Button btnCommunity = (Button) findViewById(R.id.ExerciseToCommunity);

        btnEditRunning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEditRunning = new Intent(Exercise.this, sub_running.class);
                startActivity(intentEditRunning);
            }
        });
        btnEditExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEditExercise = new Intent(Exercise.this, sub_exercise.class);
                startActivity(intentEditExercise);
            }
        });
        btnEditBiking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEditBiking = new Intent(Exercise.this, sub_biking.class);
                startActivity(intentEditBiking);
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exerToProf = new Intent(Exercise.this, Profile.class);
                startActivity(exerToProf);
            }
        });

        btnCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exerToComm = new Intent(Exercise.this, Community.class);
                startActivity(exerToComm);
            }
        });
    }

}
