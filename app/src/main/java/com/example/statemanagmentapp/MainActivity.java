package com.example.statemanagmentapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private static final String keyCount = "", keyEditText = "", keyCheckBox = "", keyToggleSwitch ="";
    private TextView textViewCount;
    private Button buttonIncrement;
    private EditText textEdit;
    private CheckBox checkBox;
    private Switch toggleSwitch;
    private int count = 0;
    private String textEditText = String.valueOf(textEdit);
    private Boolean checked = Boolean.valueOf(String.valueOf(checkBox));
    private Boolean switched = Boolean.valueOf(String.valueOf(toggleSwitch));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCount = findViewById(R.id.textViewCount);
        buttonIncrement = findViewById(R.id.buttonIncrement);
        textEdit = findViewById(R.id.textEdit);
        checkBox = findViewById(R.id.checkBox);
        toggleSwitch = findViewById(R.id.toggleSwitch);

        if(savedInstanceState != null) {
            count = savedInstanceState.getInt(keyCount);
            textEditText = savedInstanceState.getString(keyEditText);
            checked = savedInstanceState.getBoolean(keyCheckBox);
            switched = savedInstanceState.getBoolean(keyToggleSwitch);
        }
        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                updateCountText();
            }
        });
        toggleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                updateToggleSwitch();
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(keyCount, count);
        outState.putString(keyEditText, textEditText);
        outState.putBoolean(keyCheckBox, checked);
        outState.putBoolean(keyToggleSwitch, switched);
    }
    private void updateCountText() {
        textViewCount.setText("Licznik: " + count);
    }
    private void updateToggleSwitch() {
        if(checked) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            checked = false;
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            checked = true;
        }
    }
}