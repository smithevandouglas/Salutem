package com.example.salutem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Lunch extends AppCompatActivity {

    private EditText calories;
    private EditText protein;
    private EditText carbs;
    private EditText fat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        calories = (EditText) findViewById(R.id.LunchCaloriesInput);
        protein = (EditText) findViewById(R.id.LunchProteinInput);
        carbs = (EditText) findViewById(R.id.LunchCarbsInput);
        fat = (EditText) findViewById(R.id.LunchFatInput);

        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = mPreferences.edit();

        String cals = mPreferences.getString(getString(R.string.lunch_cals), "0");
        String prot = mPreferences.getString(getString(R.string.lunch_pro), "0");
        String carb = mPreferences.getString(getString(R.string.lunch_carbs), "0");
        String f = mPreferences.getString(getString(R.string.lunch_fat), "0");

        Button btnSaveLunch = (Button) findViewById(R.id.SaveLunch);

        btnSaveLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString(getString(R.string.lunch_cals), calories.getText().toString());
                editor.commit();

                editor.putString(getString(R.string.lunch_pro), protein.getText().toString());
                editor.commit();

                editor.putString(getString(R.string.lunch_carbs), carbs.getText().toString());
                editor.commit();

                editor.putString(getString(R.string.lunch_fat), fat.getText().toString());
                editor.commit();

                Intent intentBackToDiet = new Intent(Lunch.this, Diet.class);
                startActivity(intentBackToDiet);
            }
        });
    }
}
