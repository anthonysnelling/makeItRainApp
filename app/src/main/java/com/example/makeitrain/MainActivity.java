package com.example.makeitrain;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private TextView moneyValue;
    private TextView status;
    private int moneyCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moneyValue = findViewById(R.id.moneyValue);
        status = findViewById(R.id.textView2);
    }

    public void showMoney(View view) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        moneyCounter += 1000;
        Log.d("MainActivity", "onClick: Make It Rain " + moneyCounter);
        moneyValue.setText(String.valueOf(numberFormat.format(moneyCounter)));
        if (moneyCounter >= 10000){
            moneyValue.setTextColor(Color.rgb(0,255,0));
        }
        if (moneyCounter >= 30000) {
            moneyValue.setTextColor(Color.rgb(0,200,10));
            status.setText(R.string.makingSomeThreshold);
        }
        if (moneyCounter >= 50000) {
            moneyValue.setTextColor(Color.rgb(200,100,10));
            status.setText(R.string.gettingUpThresh);
        }
        if (moneyCounter >= 75000) {
            moneyValue.setTextColor(Color.rgb(255,50,10));
            status.setText(R.string.youRichThreshhold);
        }

    }

    public void showInfo(View view) {
        Log.d("MainActivity", "onClick: show Info");
        Toast.makeText(MainActivity.this, R.string.app_info, Toast.LENGTH_SHORT)
                .show();

        Snackbar.make(moneyValue, R.string.app_info,Snackbar.LENGTH_LONG)
                .setAction("more", v -> {
                    Log.d("Snack", "Show Info:SnackBar More");
                })
                .show();
    }
}