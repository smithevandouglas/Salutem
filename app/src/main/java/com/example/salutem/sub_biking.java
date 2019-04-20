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

public class sub_biking extends AppCompatActivity {

    private EditText bikingDistanceBiking;
    private EditText bikingCaloriesBiking;
    private EditText bikingTimeBiking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_biking);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bikingDistanceBiking = (EditText) findViewById(R.id.BikingDistanceBiking);
        bikingCaloriesBiking = (EditText) findViewById(R.id.BikingCaloriesBiking);
        bikingTimeBiking = (EditText) findViewById(R.id.BikingTimeBiking);

        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = mPreferences.edit();

        String dist_bik = mPreferences.getString(getString(R.string.dist_bik), "0");
        String cals_bik = mPreferences.getString(getString(R.string.cals_bik), "0");
        String time_bik = mPreferences.getString(getString(R.string.time_bik), "0");

        bikingDistanceBiking.setText(dist_bik);
        bikingCaloriesBiking.setText(cals_bik);
        bikingTimeBiking.setText(time_bik);

        Button btnBackToExercise = (Button) findViewById(R.id.BikingToExercise);

        btnBackToExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString(getString(R.string.dist_bik), bikingDistanceBiking.getText().toString());
                editor.commit();

                editor.putString(getString(R.string.cals_bik), bikingCaloriesBiking.getText().toString());
                editor.commit();

                editor.putString(getString(R.string.time_bik), bikingTimeBiking.getText().toString());
                editor.commit();

                Intent intentBackToExercise = new Intent(sub_biking.this, Exercise.class);
                startActivity(intentBackToExercise);
            }
        });
    }

}
