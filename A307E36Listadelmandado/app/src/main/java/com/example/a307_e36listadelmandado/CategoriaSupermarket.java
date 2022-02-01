package com.example.a307_e36listadelmandado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class CategoriaSupermarket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_supermarket);

        //ICONO EN ACTIONBAR
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }

    //inflado del menú
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void ListaViveres(View view) {
        Intent viveres= new Intent(this, Viveres.class);
        startActivity(viveres);
    }

    public void fnBebidas(View view) {
        Intent bebidas= new Intent(this, Bebidas.class);
        startActivity(bebidas);
    }

    public void fnFrutas(View view) {
        Intent frutas= new Intent(this, Frutas.class);
        startActivity(frutas);
    }

    public void fnPostres(View view) {
        Intent postres= new Intent(this, Postres.class);
        startActivity(postres);
    }

    public void fnEnlatados(View view) {
        Intent enlatados= new Intent(this, Enlatados.class);
        startActivity(enlatados);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.salir:
                AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
                dialogo.setTitle("Confirmación");
                dialogo.setMessage("Confirme si realmente desea terminar");
                dialogo.setCancelable(false);
                dialogo.setIcon(R.drawable.salir);
                dialogo.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                dialogo.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialogo.show();
                break;

            case R.id.acerca_de:
                startActivity(new Intent(this,AcercaDeActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}