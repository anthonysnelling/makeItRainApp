package com.example.makeitrain;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
//    private Button makeItRain;
//    private Button showInfo;
    private TextView moneyValue;
    private int moneycounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        makeItRain = findViewById(R.id.buttonMakeItRain);
        moneyValue = findViewById(R.id.moneyValue);

//        makeItRain.setOnClickListener(v -> Log.d("MainActivity", "onClick: Make It Rain"));

    }

    public void showMoney(View view) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        moneycounter += 1000;
        Log.d("MainActivity", "onClick: Make It Rain " + moneycounter );
        moneyValue.setText(String.valueOf(numberFormat.format(moneycounter)));
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