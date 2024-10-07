package com.example.pd1;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tvChangeText;

    boolean isTextChanged = false;
    boolean isColorChanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvChangeText = findViewById(R.id.tvChangeText);

        final Button buttonChangeText = findViewById(R.id.btnChangeText);
        buttonChangeText.setOnClickListener(v -> {
            if (isTextChanged) {
                tvChangeText.setText("Hello World!");
            } else {
                tvChangeText.setText("Welcome to android");
            }
            isTextChanged = !isTextChanged;
        });

        final Button buttonChangeColor = findViewById(R.id.btnChangeColor);
        buttonChangeColor.setOnClickListener(v -> {
            if (isColorChanged) {
                tvChangeText.setTextColor(Color.BLACK);
            } else {
                tvChangeText.setTextColor(Color.RED);
            }
            isColorChanged = !isColorChanged;
        });

    }
}