package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    private TextView resultTextView; // This is the only UI component in ResultActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Initialize UI component specific to ResultActivity
        resultTextView = findViewById(R.id.resultTextView);

        // Retrieve the result from the intent
        double result = getIntent().getDoubleExtra("result", 0.0);

        // Display the result
        resultTextView.setText("Result: " + result);
    }
}
