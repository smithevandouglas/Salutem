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

public class Breakfast extends AppCompatActivity {

    private EditText calories;
    private EditText protein;
    private EditText carbs;
    private EditText fat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        calories = (EditText) findViewById(R.id.BreakfastCaloriesInput);
        protein = (EditText) findViewById(R.id.BreakfastProteinInput);
        carbs = (EditText) findViewById(R.id.BreakfastCarbsInput);
        fat = (EditText) findViewById(R.id.BreakfastFatInput);

        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = mPreferences.edit();

        String cals = mPreferences.getString(getString(R.string.break_cals), "0");
        String prot = mPreferences.getString(getString(R.string.break_pro), "0");
        String carb = mPreferences.getString(getString(R.string.break_carbs), "0");
        String f = mPreferences.getString(getString(R.string.break_fat), "0");

        Button btnSaveBreakfast = (Button) findViewById(R.id.SaveBreakfast);

        btnSaveBreakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString(getString(R.string.break_cals), calories.getText().toString());
                editor.commit();

                editor.putString(getString(R.string.break_pro), protein.getText().toString());
                editor.commit();

                editor.putString(getString(R.string.break_carbs), carbs.getText().toString());
                editor.commit();

                editor.putString(getString(R.string.break_fat), fat.getText().toString());
                editor.commit();

                Intent intentBackToDiet = new Intent(Breakfast.this, Diet.class);
                startActivity(intentBackToDiet);
            }
        });
    }
}
