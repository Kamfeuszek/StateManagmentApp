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

public class MainActivity extends AppCompatActivity {

    private static final String keyCount = "count", keyEditText = "textEditText", keyCheckBox = "false", keyToggleSwitch ="false";
    private TextView textViewCount;
    private Button buttonIncrement;
    private EditText textEdit;
    private CheckBox checkBox;
    private TextView textCheckBox;
    private Switch toggleSwitch;
    private int count = 0;
    private String textEditText = "";
    private Boolean checked = false;
    private Boolean switched = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCount = findViewById(R.id.textViewCount);
        buttonIncrement = findViewById(R.id.buttonIncrement);
        textEdit = findViewById(R.id.textEdit);
        checkBox = findViewById(R.id.checkBox);
        textCheckBox = findViewById(R.id.textCheckBox);
        toggleSwitch = findViewById(R.id.toggleSwitch);

        if(savedInstanceState != null) {
            count = savedInstanceState.getInt(keyCount);
            textEditText = savedInstanceState.getString(keyEditText);
            checked = savedInstanceState.getBoolean(keyCheckBox);
            switched = savedInstanceState.getBoolean(keyToggleSwitch);
            updateCountText();
            updateEditText();
            updateCheckBox();
            updateToggleSwitch();
        }

        textEditText = String.valueOf(textEdit);
        checked = Boolean.valueOf(String.valueOf(checkBox));
        switched = Boolean.valueOf(String.valueOf(toggleSwitch));

        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                updateCountText();
            }
        });
        textEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                textEditText = textEdit.getText().toString();
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkBox.isChecked()) {
                    checked = true;
                } else {
                    checked = false;
                }
                updateCheckBox();
            }
        });
        toggleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(toggleSwitch.isChecked()) {
                    switched = true;
                } else {
                    switched = false;
                }
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
    private void updateEditText() {
        textEdit.setText(textEditText);
    }
    private void updateCheckBox() {
        if(checked) {
            textCheckBox.setText("Opcja zaznaczona");
        } else {
            textCheckBox.setText("");
        }
    }
    private void updateToggleSwitch() {
        if(switched) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}
