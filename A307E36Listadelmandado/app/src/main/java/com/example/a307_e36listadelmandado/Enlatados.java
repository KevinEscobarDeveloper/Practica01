package com.example.a307_e36listadelmandado;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Enlatados extends AppCompatActivity {
    //referencias a ListView y al adaptador
    private ListView mListado;
    private ArrayAdapter<String> arrayAdapter;

    //referencia a TextView
    private TextView mTexto;

    //referencias al array
    private ArrayList<String> productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enlatados);

        //se instancian las vistas
        mListado = findViewById(R.id.listado);
        //TextView
        mTexto = findViewById(R.id.texto);
        Typeface face = Typeface.createFromAsset(getAssets(),"fuentes/Chickens_Lovers.ttf");
        mTexto.setTypeface(face);

        //cargamos los datos al array
        cargarDatos();

        //creamos el adaptador
        arrayAdapter = new ArrayAdapter<>(this, R.layout.mi_layout,productos);
        mListado.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

        //se asocia el adaptador al ListView
        mListado.setAdapter(arrayAdapter);

        //se crea y registra un objetp listener
        mListado.setOnItemClickListener(new Enlatados.ProcesaElementoSeleccionado());
    }

    private void cargarDatos(){
        //se instancia el array
        productos = new ArrayList<>();

        //se llenan con datos
        productos.add("Piña en almíbar");
        productos.add("Sardina");
        productos.add("Chícharos");
        productos.add("Zanahoria picada");
        productos.add("Salsa de tomate");
        productos.add("Atún");
        productos.add("Salmón");
        productos.add("Aceitunas");
        productos.add("Espárragos");
        productos.add("Hongos");
        productos.add("Elotes");
        productos.add("Rajas de Jalapeño");
        productos.add("Frutas en almíbar");
    }

    //Creamos una clase que implementa a OnItemClickListener
    public class ProcesaElementoSeleccionado implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            mTexto.setText(productos.get(i));
            //mTexto.setText(mListado.getItemAtPosition(i).toString());
        }
    }

    //Se procesan los elementos que han sido seleccionados
    public void enlatados(View view){
        SparseBooleanArray sel= mListado.getCheckedItemPositions();

        if(sel==null) {
            Toast.makeText(this, "No permite selección", Toast.LENGTH_LONG).show();
        }
        else{
            //inicializa la cadena de texto
            StringBuffer cad = new StringBuffer("");

            for(int i = 0; i<sel.size(); i++) {
                if (sel.valueAt(i)) {
                    cad.append(mListado.getItemAtPosition(sel.keyAt(i)));
                    cad.append(", ");
                }
            }
            mTexto.setText(cad);
            AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
            dialogo.setMessage("VUELVA PRONTO");

            dialogo.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int wich) {
                    //no hace nada
                }
            });

            dialogo.show();
        }
    }
}