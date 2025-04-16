package com.example.reajustesalarial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtSalario;
    RadioGroup radioGroup;
    Button btnCalcular;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSalario = findViewById(R.id.edtSalario);
        radioGroup = findViewById(R.id.radioGroup);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String salarioStr = edtSalario.getText().toString();

                if (salarioStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Digite o salário", Toast.LENGTH_SHORT).show();
                    return;
                }

                double salario = Double.parseDouble(salarioStr);
                double percentual = 0.0;

                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == R.id.radio40) {
                    percentual = 0.40;
                } else if (selectedId == R.id.radio45) {
                    percentual = 0.45;
                } else if (selectedId == R.id.radio50) {
                    percentual = 0.50;
                } else {
                    Toast.makeText(MainActivity.this, "Escolha um percentual de aumento", Toast.LENGTH_SHORT).show();
                    return;
                }

                double novoSalario = salario + (salario * percentual);
                txtResultado.setText(String.format("Novo salário: R$ %.2f", novoSalario));
            }
        });
    }
}
