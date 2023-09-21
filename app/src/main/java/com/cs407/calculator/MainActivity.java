package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText firstNumberEditText, secondNumberEditText;
    private Button additionButton, subtractionButton, multiplicationButton, divisionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumberEditText = findViewById(R.id.num1EditText);
        secondNumberEditText = findViewById(R.id.num2EditText);
        additionButton = findViewById(R.id.addButton);
        subtractionButton = findViewById(R.id.subtractButton);
        multiplicationButton = findViewById(R.id.multiplyButton);
        divisionButton = findViewById(R.id.divideButton);


        additionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performOperation('+');
            }
        });

        subtractionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performOperation('-');
            }
        });

        multiplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performOperation('*');
            }
        });

        divisionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performOperation('/');
            }
        });
    }

    private void performOperation(char operator) {

        String num1Str = firstNumberEditText.getText().toString();
        String num2Str = secondNumberEditText.getText().toString();

        if (TextUtils.isEmpty(num1Str) || TextUtils.isEmpty(num2Str)) {
            // Handle empty input
            showToast("Please enter two numbers.");
            return;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    showToast("Cannot divide by zero.");
                    return;
                }
                result = num1 / num2;
                break;
        }

        Intent intent = new Intent(this, Result.class);
        intent.putExtra("result", result);

        startActivity(intent);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
