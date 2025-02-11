package com.vanzaga.buttonradiocalcular;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etNum1, etNum2;
    private TextView tvResultado;
    private RadioButton rbSuma, rbResta, rbMultiplicar, rbDivision, rbModulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.txt_num1);
        etNum2 = findViewById(R.id.txt_num2);
        tvResultado = findViewById(R.id.text_resultado);
        rbSuma = findViewById(R.id.radio_button_1);
        rbResta = findViewById(R.id.radio_button_2);
        rbMultiplicar = findViewById(R.id.radio_button_multiplicar);
        rbDivision = findViewById(R.id.radio_button_dividir);
        rbModulo = findViewById(R.id.radio_button_modulo);
    }

    public void calcular(View view) {
        String num1 = etNum1.getText().toString();
        String num2 = etNum2.getText().toString();
        String resultado = "" ;
        int opcion = 0;

        if (!num1.isEmpty() && !num2.isEmpty()) {
                double n1 = Double.parseDouble(num1);
                double n2 = Double.parseDouble(num2);

                if (rbSuma.isChecked()) {
                    opcion = 1;
                } else if (rbResta.isChecked()) {
                    opcion = 2;
                } else if (rbMultiplicar.isChecked()) {
                    opcion = 3;
                } else if (rbDivision.isChecked()) {
                    opcion = 4;
                } else if (rbModulo.isChecked()) {
                    opcion = 5;
                }

                switch (opcion) {
                    case 1:
                        double suma = n1 + n2;
                        resultado = String.format("%.2f", suma);
                        break;

                    case 2:
                        double resta = n1 - n2;
                        if (n2 > n1) {
                            resta = n2 - n1;
                        }
                        resultado = String.format("%.2f", resta);
                        break;

                    case 3:
                        double multiplicar = n1 * n2;
                        resultado = String.format("%.2f", multiplicar);
                        break;

                    case 4:
                        double division = n1 / n2;
                        resultado = String.format("%.2f", division);
                        break;

                    case 5:
                        double modulo = n1 % n2;
                        resultado = String.format("%.2f", modulo);
                        break;

                    default:
                        resultado = "Selecciona una opción";
                        break;
                }

                tvResultado.setText(resultado);

        } else {
            tvResultado.setText(HtmlCompat.fromHtml(getString(R.string.mensaje), HtmlCompat.FROM_HTML_MODE_LEGACY));
        }
    }
}

    /*public void calcular(View view) {
        String num1 = etNum1.getText().toString();
        String num2 = etNum2.getText().toString();

        if (!num1.isEmpty() && !num2.isEmpty()) {

            double n1 = Double.parseDouble(num1);
            double n2 = Double.parseDouble(num2);

            if (rbSuma.isChecked() == true) {
                double suma = n1 + n2;
                // Converftimos el valor suma entero a string es hacer un casting
                // String resultado = String.valueOf(suma);
                String resultado = String.format("%.2f", suma);
                tvResultado.setText(resultado);
            } else if (rbResta.isChecked() == true) {
                double resta = n1 - n2;
                if (n2 > n1) {
                    resta = n2 - n1;
                }
                // String resultado = String.valueOf(resta);
                String resultado = String.format("%.2f", resta);
                tvResultado.setText(resultado);
            } else if (rbMultiplicar.isChecked() == true) {
                double multiplicar = n1 * n2;
                // String resultado = String.valueOf(multiplicar);
                String resultado = String.format("%.2f", multiplicar);
                tvResultado.setText(resultado);
            } else if (rbDivision.isChecked() == true) {
                double division = n1 / n2;
                // String resultado = String.valueOf(division);
                String resultado = String.format("%.2f", division);
                tvResultado.setText(resultado);
            } else if (rbModulo.isChecked() == true) {
                double modulo = n1 % n2;
                // String resultado = String.valueOf(modulo);
                String resultado = String.format("%.2f", modulo);
                tvResultado.setText(resultado);
            }
        } else {
            tvResultado.setText(HtmlCompat.fromHtml(getString(R.string.mensaje), HtmlCompat.FROM_HTML_MODE_LEGACY));
        }
    }*/


