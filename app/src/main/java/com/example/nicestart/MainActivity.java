package com.example.nicestart;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView resultado;
    private EditText numero1,numero2;
    private Button suma, resta, mult, div, calc;
    private double valor1, valor2;
    private int operacion;
    private String ponerTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        resultado = findViewById(R.id.greet);
        numero1 = findViewById(R.id.num1);
        numero2 = findViewById(R.id.num2);
        suma = findViewById(R.id.plus);
        resta = findViewById(R.id.minus);
        mult = findViewById(R.id.multiply);
        div = findViewById(R.id.divide);
        calc = findViewById(R.id.calc);

        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion = 1;
            }
        });

        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion = 2;
            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion = 3;
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion = 4;
            }
        });

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valor1 = Double.parseDouble(numero1.getText().toString());
                valor2 = Double.parseDouble(numero2.getText().toString());

                switch (operacion) {
                    case 1:
                        ponerTexto = ""+(valor1+valor2);
                        break;
                    case 2:
                        ponerTexto = ""+(valor1-valor2);
                        break;
                    case 3:
                        ponerTexto = ""+(valor1*valor2);
                        break;
                    case 4:
                        ponerTexto = ""+((double)valor1/valor2);
                        break;
                    default:
                        ponerTexto = "No válido";
                }
                resultado.setText(ponerTexto);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}