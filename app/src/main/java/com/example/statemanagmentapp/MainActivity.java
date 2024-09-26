package com.example.statemanagmentapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private static final String keyCount = "", keyEditText = "", keyCheckBox = "", keyToggleSwitch ="";
    private TextView textViewCount;
    private Button buttonIncrement;
    private EditText textEdit;
    private CheckBox checkBox;
    private Switch toggleSwitch;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCount = findViewById(R.id.textViewCount);
        buttonIncrement = findViewById(R.id.buttonIncrement);
        textEdit = findViewById(R.id.textEdit);
        checkBox = findViewById(R.id.checkBox);
        toggleSwitch = findViewById(R.id.toggleSwitch);

        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                updateCountText();
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(keyCount, count);
        outState.putString(keyEditText, String.valueOf(textEdit));
        outState.putString(keyCheckBox, String.valueOf(checkBox));
        outState.putString(keyToggleSwitch, String.valueOf(toggleSwitch));
    }
    private void updateCountText() {
        textViewCount.setText("Licznik: " + count);
    }
}