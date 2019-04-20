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

public class Meditation extends AppCompatActivity {

    private EditText minutesMeditatedToday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        minutesMeditatedToday = (EditText) findViewById(R.id.MinutesMeditatedToday);

        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = mPreferences.edit();

        String min_med = mPreferences.getString(getString(R.string.min_med), "0");
        minutesMeditatedToday.setText(min_med);

        Button saveMeditation = (Button) findViewById(R.id.SaveMeditation);

        saveMeditation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString(getString(R.string.min_med), minutesMeditatedToday.getText().toString());
                editor.commit();

                Intent intentBackToMental = new Intent(Meditation.this, Mental.class);
                startActivity(intentBackToMental);
            }
        });
    }
}
