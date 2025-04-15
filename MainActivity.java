package com.example.atividade3;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText nome = findViewById(R.id.nome);
        EditText matricula = findViewById(R.id.matricula);
        EditText nota1 = findViewById(R.id.nota1);
        EditText nota2 = findViewById(R.id.nota2);
        Button calcular = findViewById(R.id.calcular);
        TextView resultado = findViewById(R.id.resultado);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strNota1 = nota1.getText().toString();
                String strNota2 = nota2.getText().toString();
                String nomeAluno = nome.getText().toString();

                if (!strNota1.isEmpty() && !strNota2.isEmpty()) {
                    double n1 = Double.parseDouble(strNota1);
                    double n2 = Double.parseDouble(strNota2);
                    double notaFinal = ((n1 * 0.4) + (n2 * 0.6));
                    resultado.setText("A nota do aluno " + nomeAluno + " foi: " + notaFinal);
                } else {
                    resultado.setText("Preencha as notas");
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
