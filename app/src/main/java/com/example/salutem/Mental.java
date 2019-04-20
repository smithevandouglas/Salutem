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

public class Mental extends AppCompatActivity {

    private TextView mood_entry;
    private TextView journal_entry;
    private TextView meditation_minutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mood_entry = (TextView) findViewById(R.id.LatestMoodEntry);
        journal_entry = (TextView) findViewById(R.id.LatestJournalEntry);
        meditation_minutes = (TextView) findViewById(R.id.MinutesMeditatedToday);

        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mPreferences.edit();

        String moo_ent = mPreferences.getString(getString(R.string.moo_ent), "None yet!");
        String jou_ent = mPreferences.getString(getString(R.string.jou_ent), "No journal entry yet! Start keeping your journal today!");
        String min_med = mPreferences.getString(getString(R.string.min_med), "0");

        mood_entry.setText(moo_ent);
        journal_entry.setText(jou_ent);
        meditation_minutes.setText(min_med);

        Button mentalToMood = (Button) findViewById(R.id.MentalToMood);
        Button mentalToMeditation = (Button) findViewById(R.id.MentalToMeditation);
        Button mentalToProfile = (Button) findViewById(R.id.MentalToProfile);
        Button mentalToCommunity = (Button) findViewById(R.id.MentalToCommunity);

        mentalToMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEditMood = new Intent(Mental.this, Mood.class);
                startActivity(intentEditMood);
            }
        });

        mentalToMeditation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEditMeditation = new Intent(Mental.this, Meditation.class);
                startActivity(intentEditMeditation);
            }
        });

        mentalToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGoToProfile = new Intent(Mental.this, Profile.class);
                startActivity(intentGoToProfile);
            }
        });

        mentalToCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGoToCommunity = new Intent(Mental.this, Community.class);
                startActivity(intentGoToCommunity);
            }
        });
    }
}
