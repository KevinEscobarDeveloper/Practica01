package com.example.a307_e36listadelmandado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AcercaDeActivity extends AppCompatActivity {
    //referencias a las vistas
    TextView mTitulo, mContenido;

    //referencia al array
    String[] arrayAcercaDe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        //se instancian las vistas
        mTitulo = findViewById(R.id.titulo);
        mContenido = findViewById(R.id.contenido);

        //creamos la instancia del array y la poblamos(llenamos de datos)
        arrayAcercaDe = getResources().getStringArray(R.array.acerca_de);

        //colocacion del titulo
        mTitulo.setText(arrayAcercaDe[0]);

        //colocacion del contenido
        String cad = "";
        for (int i = 1; i < arrayAcercaDe.length; i++){
            cad+= arrayAcercaDe[i] + "\n";
        }
        mContenido.setText(cad);
    }
}