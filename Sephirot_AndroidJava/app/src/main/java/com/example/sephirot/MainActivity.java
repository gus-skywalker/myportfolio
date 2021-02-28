package com.example.sephirot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView mDisplayDate;
    private Button btCalculate;
    private DatePickerDialog.OnDateSetListener setDateListener;
    private Integer gDate; // get global variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDisplayDate = (TextView) findViewById(R.id.putDate);
        btCalculate = (Button) findViewById(R.id.button);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                final int year = cal.get(Calendar.YEAR);
                final int month = cal.get(Calendar.MONTH);
                final int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                        android.R.style.Theme_Black_NoTitleBar,
                        setDateListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        setDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = month + "/" + day + "/" + year;

                gDate = day + month + year; // Stores the sum (int) to calculate from a global variable

                mDisplayDate.setText(date); // Output of selected date

            }
        };

        btCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 int id = 0; // Get a [0...8] index to correspond to the array of Sephira.java
                try {
                    id = digSum(gDate) - 1;
                } catch (Exception e) {
                    e.printStackTrace();
                    if (id==0) {
                        Toast.makeText(MainActivity.this, "Choose a date on calendar", Toast.LENGTH_SHORT).show();
                        // -----?? HOW TO RESOLVE THIS PROBLEM ??-------- //
                    }
                }

                Intent intent = new Intent(MainActivity.this, SephiraActivity.class);
                intent.putExtra(SephiraActivity.EXTRA_ID, (int)id);
                startActivity(intent);
            }
        });
    }


    // Method to convert the date to one digit

    static int digSum(int n) {

        int sum = 0;

        // Loop to do sum while
        // sum is not less than
        // or equal to 9
        while (n > 0 || sum > 9)
        {
            if (n == 0) {
                n = sum;
                sum = 0;
            }
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.about:
                Toast.makeText(this, "Sobre", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.addperson:
                Toast.makeText(this, "Acrescentar uma pessoa", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.btSend:
                Toast.makeText(this, "Compartilhe esse app", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}