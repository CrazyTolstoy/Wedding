package com.example.wedding;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.preference.PreferenceManager;


import com.example.wedding.databinding.ActivityFirstTimeOpenBinding;

import java.util.Calendar;

public class FirstTimeOpen extends AppCompatActivity {

    private ActivityFirstTimeOpenBinding binding;
    private EditText selectedDateTV,mladaT,mladozenjaT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFirstTimeOpenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mladaT=findViewById(R.id.mlada);
        mladozenjaT=findViewById(R.id.mladozenja);
        Button pickDateBtn = findViewById(R.id.idBtnPickDate);
        selectedDateTV = findViewById(R.id.idTVSelectedDate);
        SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        boolean isFirstLaunch = sharedPreferences.getBoolean("isFirstLaunch", true);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (isFirstLaunch) {
            // Show the landing page
            setContentView(binding.getRoot());
        } else {
            // Proceed to the Home Activity
            startActivity(new Intent(FirstTimeOpen.this, MainActivity.class));
            finish();
        }

        pickDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting
                // the instance of our calendar.
                final Calendar c = Calendar.getInstance();

                // on below line we are getting
                // our day, month and year.
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // on below line we are creating a variable for date picker dialog.
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        FirstTimeOpen.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our text view.
                                selectedDateTV.setText(dayOfMonth + "." + (monthOfYear + 1) + "." + year);

                            }
                        },
                        // on below line we are passing year,
                        // month and day for selected date in our date picker.
                        year, month, day);
                // at last we are calling show to
                // display our date picker dialog.
                datePickerDialog.show();
            }
        });


        Button saveButton = findViewById(R.id.next);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("mlada", mladaT.getText().toString());
                editor.putString("mladozenja", mladozenjaT.getText().toString());
                editor.apply();

                String mladaValue = mladaT.getText().toString();
                String mladozenjaValue = mladozenjaT.getText().toString();
                if (mladaValue.equals("")||mladozenjaValue.equals("")||selectedDateTV.getText().toString().equals("")) {
                    Toast.makeText(FirstTimeOpen.this, "Potrebno je popuniti sva polja", Toast.LENGTH_SHORT).show();

                } else {
                    markFirstLaunch(false);
                    startActivity(new Intent(FirstTimeOpen.this, MainActivity.class));
                    finish();
                }
            }
        });

    }
    private void markFirstLaunch(boolean isFirstLaunch) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isFirstLaunch", isFirstLaunch);
        editor.apply();
    }

}