package com.pgeschke.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double conversionRate = 0.82;
    double currencyEntered = 0.0;
    double convertedCurrency;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText currency = (EditText) findViewById(R.id.txtCurrency);
        final RadioButton usToEu = (RadioButton) findViewById(R.id.radUStoEU);
        final RadioButton euToUS = (RadioButton) findViewById(R.id.radEUtoUS);
        final TextView result = (TextView)findViewById(R.id.txtResult);
        Button convert = (Button) findViewById(R.id.btnConvert);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currencyEntered = Double.parseDouble(currency.getText().toString());
                DecimalFormat USCurrency = new DecimalFormat("$##,###.00");
                DecimalFormat EUCurrency = new DecimalFormat("€##,###.00");
                if (usToEu.isChecked()){
                    if (currencyEntered <= 10000){
                        convertedCurrency = currencyEntered * conversionRate;
                        result.setText(EUCurrency.format(convertedCurrency));
                    }else{
                        Toast.makeText(MainActivity.this, "Amount must be less than $10,000",
                                Toast.LENGTH_LONG).show();
                    }
                }
                if (euToUS.isChecked()){
                    if (currencyEntered <=8150.50){
                        convertedCurrency = currencyEntered / conversionRate;
                        result.setText(USCurrency.format(convertedCurrency));
                    }else {
                        Toast.makeText(MainActivity.this,"Amount must be less than €8150.50",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
