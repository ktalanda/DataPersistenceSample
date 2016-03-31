package com.example.datapersistancesample.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.datapersistancesample.R;
import com.example.datapersistancesample.ui.category.CategoryActivity;
import com.example.datapersistancesample.ui.note.NoteActivity;
import com.example.datapersistancesample.ui.settings.SettingsActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.main_shared_preferences_button)
    public void onSharedPreferencesButtonClick(View view) {
        startActivity(new Intent(this, SettingsActivity.class));
    }

    @OnClick(R.id.main_database_button)
    public void onDatabaseButtonClick(View view) {
        startActivity(new Intent(this, CategoryActivity.class));
    }

    @OnClick(R.id.main_file_button)
    public void onFileButtonClick(View view) {
        startActivity(new Intent(this, NoteActivity.class));
    }
}
