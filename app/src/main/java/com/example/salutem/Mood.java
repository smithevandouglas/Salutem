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

public class Mood extends AppCompatActivity {

    private EditText moodEntry;
    private EditText journalEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        moodEntry = (EditText) findViewById(R.id.MoodEntry);
        journalEntry = (EditText) findViewById(R.id.JournalEntry);

        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = mPreferences.edit();

        String moo_ent = mPreferences.getString(getString(R.string.moo_ent), "0");
        String jou_ent = mPreferences.getString(getString(R.string.jou_ent), "0");

        moodEntry.setText(moo_ent);
        journalEntry.setText(jou_ent);

        Button saveMood = (Button) findViewById(R.id.SaveMood);

        saveMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString(getString(R.string.moo_ent), moodEntry.getText().toString());
                editor.commit();

                editor.putString(getString(R.string.jou_ent), journalEntry.getText().toString());
                editor.commit();

                Intent intentBackToMental = new Intent(Mood.this, Mental.class);
                startActivity(intentBackToMental);
            }
        });
    }
}
