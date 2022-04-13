package com.example.ae01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/ {

    private TextView TVResultado;
    private EditText PTPalabra;
    private Button BtnProcesar;
    private String palabra;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarVistas();
        /*
        Al configurar un boton para decirle que este pnediente
        al eventp click de ese boton en pantalla con el use del metodo
        .setOn<clickListener()
        Lo que ese metodo esta esperando como parametro es ena funcion
        que sera la funcion click que activara las acciones a realizar cuando se presiono el boton
        Cuando se pasa una funcion como parametro estas generalmento
        son conocudas unas funciones anonimas
        La idea es que sea
        del metodo que la recibe como parametro
         */
        BtnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ESte metodo onCLick solo existe en el ambito del boton
                //BtnProcesar, lo que se haga aca solo sirve para ese boton
                recibirInformacion();
                invertirPalabra();
            }
        });
    }

    private void invertirPalabra() {

        //Una manera directa de invertir una palabra
        palabra = new StringBuilder(palabra).reverse().toString();
        TVResultado.setText(palabra);
    }

    private void recibirInformacion() {
        palabra = PTPalabra.getText().toString();
    }

    private void iniciarVistas() {
        TVResultado = findViewById(R.id.TVResultado);
        PTPalabra = findViewById(R.id.PTPalabra);
        BtnProcesar = findViewById(R.id.BtnProcesar);
    }

    /*@Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.BtnProcesar:
                break;
            case R.id.LResultado:
                break;
            case R.id.TBPalabra:
                break;
        }
    }*/
}