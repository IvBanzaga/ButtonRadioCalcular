package com.vanzaga.buttonradiocalcular;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etNum1, etNum2;
    private TextView tvResultado;
    private RadioButton rbSuma, rbResta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        etNum1 = (EditText) findViewById(R.id.txt_num1);
        etNum2 = (EditText) findViewById(R.id.txt_num2);
        tvResultado = (TextView) findViewById(R.id.text_resultado);
        rbSuma = (RadioButton) findViewById(R.id.radio_button_1);
        rbResta = (RadioButton) findViewById(R.id.radio_button_2);
    }

    public void calcular(View view) {
        String num1 = etNum1.getText().toString();
        String num2 = etNum2.getText().toString();

        double n1 = Double.parseDouble(num1);
        double n2 = Double.parseDouble(num2);

        if (rbSuma.isChecked() == true){
            double suma = n1 + n2;
            // converftimos el valor suma entero a string es hacer un casting
            //String resultado = String.valueOf(suma);
            String resultado = String.format("%.2f", suma);
            tvResultado.setText(resultado);
        } else if (rbResta.isChecked() == true){
            double resta = n1 - n2;
            //String resultado = String.valueOf(resta);
            String resultado = String.format("%.2f", resta);
            tvResultado.setText(resultado);
        }
    }
}