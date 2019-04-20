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

public class Diet extends AppCompatActivity {

    private TextView breakfastCalories;
    private TextView breakfastProtein;
    private TextView breakfastCarbohydrates;
    private TextView breakfastFat;
    private TextView lunchCalories;
    private TextView lunchProtein;
    private TextView lunchCarbohydrates;
    private TextView lunchFat;
    private TextView dinnerCalories;
    private TextView dinnerProtein;
    private TextView dinnerCarbohydrates;
    private TextView dinnerFat;
    private TextView calories;
    private TextView protein;
    private TextView carbohydrates;
    private TextView fat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        breakfastCalories = (TextView) findViewById(R.id.breakCals);
        breakfastProtein = (TextView) findViewById(R.id.breakProt);
        breakfastCarbohydrates = (TextView) findViewById(R.id.breakCarbs);
        breakfastFat = (TextView) findViewById(R.id.breakFat);
        lunchCalories = (TextView) findViewById(R.id.lunchCals);
        lunchProtein = (TextView) findViewById(R.id.lunchProt);
        lunchCarbohydrates = (TextView) findViewById(R.id.lunchCarbs);
        lunchFat = (TextView) findViewById(R.id.lunchFat);
        dinnerCalories = (TextView) findViewById(R.id.dinnerCals);
        dinnerProtein = (TextView) findViewById(R.id.dinnerProt);
        dinnerCarbohydrates = (TextView) findViewById(R.id.dinnerCarbs);
        dinnerFat = (TextView) findViewById(R.id.dinnerFat);
        calories = (TextView) findViewById(R.id.cals);
        protein = (TextView) findViewById(R.id.prot);
        carbohydrates = (TextView) findViewById(R.id.carbs);
        fat = (TextView) findViewById(R.id.fat);

        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mPreferences.edit();

        String breCals = mPreferences.getString(getString(R.string.break_cals), "0");
        String brePro = mPreferences.getString(getString(R.string.break_pro), "0");
        String breCarbs = mPreferences.getString(getString(R.string.break_carbs), "0");
        String breFat = mPreferences.getString(getString(R.string.break_fat), "0");
        String lunCals = mPreferences.getString(getString(R.string.lunch_cals), "0");
        String lunPro = mPreferences.getString(getString(R.string.lunch_pro), "0");
        String lunCarbs = mPreferences.getString(getString(R.string.lunch_carbs), "0");
        String lunFat = mPreferences.getString(getString(R.string.lunch_fat), "0");
        String dinCals = mPreferences.getString(getString(R.string.dinner_cals), "0");
        String dinPro = mPreferences.getString(getString(R.string.dinner_pro), "0");
        String dinCarbs = mPreferences.getString(getString(R.string.dinner_carbs), "0");
        String dinFat = mPreferences.getString(getString(R.string.dinner_fat), "0");

        int total_cals = Integer.parseInt(breCals) + Integer.parseInt(lunCals) + Integer.parseInt(dinCals);
        editor.putString(getString(R.string.total_cals), Integer.toString(total_cals));
        editor.commit();
        calories.setText(Integer.toString(total_cals));

        int total_pro = Integer.parseInt(brePro) + Integer.parseInt(lunPro) + Integer.parseInt(dinPro);
        editor.putString(getString(R.string.total_pro), Integer.toString(total_pro));
        editor.commit();
        protein.setText(Integer.toString(total_pro));

        int total_carbs = Integer.parseInt(breCarbs) + Integer.parseInt(lunCarbs) + Integer.parseInt(dinCarbs);
        editor.putString(getString(R.string.total_carbs), Integer.toString(total_carbs));
        editor.commit();
        carbohydrates.setText(Integer.toString(total_carbs));

        int total_fat = Integer.parseInt(breFat) + Integer.parseInt(lunFat) + Integer.parseInt(dinFat);
        editor.putString(getString(R.string.total_fat), Integer.toString(total_fat));
        editor.commit();
        fat.setText(Integer.toString(total_fat));

        breakfastCalories.setText(breCals);
        breakfastProtein.setText(brePro);
        breakfastCarbohydrates.setText(breCarbs);
        breakfastFat.setText(breFat);
        lunchCalories.setText(lunCals);
        lunchProtein.setText(lunPro);
        lunchCarbohydrates.setText(lunCarbs);
        lunchFat.setText(lunFat);
        dinnerCalories.setText(dinCals);
        dinnerProtein.setText(dinPro);
        dinnerCarbohydrates.setText(dinCarbs);
        dinnerFat.setText(dinFat);

        Button btnBreakfast = (Button) findViewById(R.id.DietToBreakfast);
        Button btnLunch = (Button) findViewById(R.id.DietToLunch);
        Button btnDinner = (Button) findViewById(R.id.DietToDinner);
        Button btnProfile = (Button) findViewById(R.id.DietToProfile);
        Button btnCommunity = (Button) findViewById(R.id.DietToCommunity);

        btnBreakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dietToBreak = new Intent(Diet.this, Breakfast.class);
                startActivity(dietToBreak);
            }
        });

        btnLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dietToLunc = new Intent(Diet.this, Lunch.class);
                startActivity(dietToLunc);
            }
        });

        btnDinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dietToDinn = new Intent(Diet.this, Dinner.class);
                startActivity(dietToDinn);
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dietToProf = new Intent(Diet.this, Profile.class);
                startActivity(dietToProf);
            }
        });

        btnCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dietToComm = new Intent(Diet.this, Community.class);
                startActivity(dietToComm);
            }
        });
    }
}
