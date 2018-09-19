package com.rawks.jeremy.medicalcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{
    final double conversionRate = 2.2;  // Conversion rate from kg to lb
    double weightEntered;               // Weight entered by user
    double convertedWeight;             // Converted weight
    final int maxKg = 225;              // Maximum weight in kg that can be converted
    final int maxLb = 500;              // Maximum weight in lb that can be converted

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configure the action bar to display the icon
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        // Create Java object representations of all widgets
        final EditText weight = findViewById(R.id.txtWeight);
        final RadioButton lbToKilo = findViewById(R.id.radLbToKilo);
        final RadioButton kiloToLb = findViewById(R.id.radKiloToLb);
        final TextView result = findViewById(R.id.txtResult);
        final Button convert = findViewById(R.id.btnConvert);

        convert.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                weightEntered = Double.parseDouble(weight.getText().toString());
                DecimalFormat tenth = new DecimalFormat("#.#");

                if (lbToKilo.isChecked())
                {
                    if (weightEntered <= maxLb)
                    {
                        convertedWeight = weightEntered / conversionRate;
                        result.setText(tenth.format(convertedWeight) + " kilograms");
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Pounds must be less than " + Integer.toString(maxLb), Toast.LENGTH_LONG).show();
                    }
                }

                if (kiloToLb.isChecked())
                {
                    if (weightEntered <= maxKg)
                    {
                        convertedWeight = weightEntered * conversionRate;
                        result.setText(tenth.format(convertedWeight) + " pounds");
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Kilos must be less than " + Integer.toString(maxKg), Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
}