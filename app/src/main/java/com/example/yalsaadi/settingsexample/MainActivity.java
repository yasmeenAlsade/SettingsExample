package com.example.yalsaadi.settingsexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setUpSharedPreferences();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent startSettingsActivity = new Intent(this, SettingsActivity.class);
            startActivity(startSettingsActivity);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setUpSharedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if ((sharedPreferences.getBoolean(getString(R.string.pref_show_bass_key), true)) == true)
            mTextView.setText("Shown");
        else
            mTextView.setText("Hidden");

        if (sharedPreferences.getString(getString(R.string.pref_color_key), getString(R.string.pref_color_red_value)).equals("red"))
            mTextView.setBackgroundColor(Color.RED);
        else if (sharedPreferences.getString(getString(R.string.pref_color_key), getString(R.string.pref_color_red_value)).equals("green"))
            mTextView.setBackgroundColor(Color.GREEN);
        else
            mTextView.setBackgroundColor(Color.BLUE);
    }
}
