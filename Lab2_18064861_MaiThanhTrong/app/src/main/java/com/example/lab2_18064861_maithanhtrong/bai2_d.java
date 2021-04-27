package com.example.lab2_18064861_maithanhtrong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.abhinav.passwordgenerator.PasswordGenerator;

public class bai2_d extends AppCompatActivity {
    private boolean isLowercaseLetter;
    private boolean isUppercaseLetter;
    private boolean isNumber;
    private boolean isSpecialSymbol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2_d);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_lowercase:
                if (checked) {
                    isLowercaseLetter = true;
                } else {
                    isLowercaseLetter = false;
                }
                break;
            case R.id.checkbox_uppercase:
                if (checked) {
                    isUppercaseLetter = true;
                } else {
                    isUppercaseLetter = false;
                }
                break;
            case R.id.checkbox_num:
                if (checked) {
                    isNumber = true;
                } else {
                    isUppercaseLetter = false;
                }
                break;
            case R.id.checkbox_spec_symbol:
                if (checked) {
                    isSpecialSymbol = true;
                } else {
                    isSpecialSymbol = false;
                }
                break;
        }
    }

    public void onGeneratePassword(View view) {
        EditText editTextPassLength = (EditText) findViewById(R.id.editTextPassLength);
        TextView txtGeneratedPassword = (TextView) findViewById(R.id.txtCreatedPassword);
        PasswordGenerator generatedPassword = new PasswordGenerator(Integer.parseInt(editTextPassLength.getText().toString()), isUppercaseLetter, isLowercaseLetter, isSpecialSymbol, isNumber);
        txtGeneratedPassword.setText(generatedPassword.generatePassword());
    }
}
