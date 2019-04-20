package com.example.salutem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    private TextView timeExercise;
    private TextView calsBurned;
    private TextView calsTarget;
    private TextView calsConsumed;
    private TextView calsRemaining;
    private TextView protein;
    private TextView carbs;
    private TextView fat;
    private TextView minutesMeditated;
    private TextView latestMood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        timeExercise = (TextView) findViewById(R.id.MinutesExercisedToday);
        calsBurned = (TextView) findViewById(R.id.CaloriesBurnedToday);
        calsTarget = (TextView) findViewById(R.id.TargetCalories);
        calsConsumed = (TextView) findViewById(R.id.CaloriesConsumedToday);
        calsRemaining = (TextView) findViewById(R.id.CaloriesRemainingToday);
        protein = (TextView) findViewById(R.id.protein);
        carbs = (TextView) findViewById(R.id.carbs);
        fat = (TextView) findViewById(R.id.fat);
        minutesMeditated = (TextView) findViewById(R.id.MinutesMeditatedToday);
        latestMood = (TextView) findViewById(R.id.LatestMood);

        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mPreferences.edit();

        String time_exe = mPreferences.getString(getString(R.string.total_mins_exe), "0");
        String cals_bur = mPreferences.getString(getString(R.string.total_cals_burned), "0");
        String cals_tar = mPreferences.getString(getString(R.string.daily_calories_target), "2000");
        String cals_con = mPreferences.getString(getString(R.string.total_cals), "0");
        String prot = mPreferences.getString(getString(R.string.total_pro), "0");
        String carb = mPreferences.getString(getString(R.string.total_carbs), "0");
        String fats = mPreferences.getString(getString(R.string.total_fat), "0");
        String min_medi = mPreferences.getString(getString(R.string.min_med), "0");
        String lat_mood = mPreferences.getString(getString(R.string.moo_ent), "No Entry");

        timeExercise.setText(time_exe);
        calsBurned.setText(cals_bur);
        calsTarget.setText(cals_tar);
        calsConsumed.setText(cals_con);
        minutesMeditated.setText(min_medi);
        latestMood.setText(lat_mood);
        protein.setText(prot);
        carbs.setText(carb);
        fat.setText(fats);

        int cals_rem = Integer.parseInt(cals_tar) - Integer.parseInt(cals_con) + Integer.parseInt(cals_bur);
        calsRemaining.setText(Integer.toString(cals_rem));

        Button btnProfile = (Button) findViewById(R.id.ProfileToProfile);
        Button btnCommunity = (Button) findViewById(R.id.ProfileToCommunity);
        Button btnExercise = (Button) findViewById(R.id.ProfileToExercise);
        Button btnDiet = (Button) findViewById(R.id.ProfileToDiet);
        Button btnMental = (Button) findViewById(R.id.ProfileToMental);

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profToProf = new Intent(Profile.this, Profile.class);
                startActivity(profToProf);
            }
        });

        btnCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profToComm = new Intent(Profile.this, Community.class);
                startActivity(profToComm);
            }
        });

        btnExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profToExer = new Intent(Profile.this, Exercise.class);
                startActivity(profToExer);
            }
        });

        btnDiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profToDiet = new Intent(Profile.this, Diet.class);
                startActivity(profToDiet);
            }
        });

        btnMental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profToMental = new Intent(Profile.this, Mental.class);
                startActivity(profToMental);
            }
        });
    }
}
