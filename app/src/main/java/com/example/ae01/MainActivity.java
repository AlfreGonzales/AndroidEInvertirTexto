package com.example.ae01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/ {

    private TextView TVResultado;
    private EditText PTPalabra;
    private Button BtnProcesar;
    private String palabra;
    private TextView TVPalindroma;
    private Button BtnMensaje;
    private String invertido;



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
        BtnMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarMensaje();
            }
        });
    }

    private void mostrarMensaje() {
        /*
        Para mostrar mensjes en pantalla, uds pueden usar
        sirve para mostrar informacion al usuario acerca de ciertos
        procesos que hayan pasado, confirmaciones, mostrsar algun mensajes y otros
        */
        //estatico
        /*
        En toast tiene un metodo llamado makeTest que es donde configuraran
        lo que se quiere mostrar al usuario, para ello deben pasar estos para:
        -contexto (ambito) de la pantalla donde se va adibujar ese menasaje
        -cadena de caracteres: el mensaje a mostrar;
        -una constante de duracion del mensaje en pantalla para que dure
        Finalmente deben decirle al Toast que se mustre cn esa configuracion
        y para ello usan el metodo o evento .show()
         */
        Toast.makeText(this,evaluarPalindroma(),Toast.LENGTH_LONG).show();
    }

    private void invertirPalabra() {

        //Una manera directa de invertir una palabra
        //palabra = new StringBuilder(palabra).reverse().toString();
        //TVResultado.setText(palabra);
        invertido = "";
        for(int i = this.palabra.length() - 1; i >= 0; i--){
            invertido += this.palabra.charAt(i);
        }
        TVResultado.setText(invertido);

        if(palabra.equals(invertido)){
            TVPalindroma.setText("La palabra es palindroma");
        }
        else{
            TVPalindroma.setText("La palabra NO es palindroma");
        }
        //FIN
    }

    private void recibirInformacion() {
        palabra = PTPalabra.getText().toString();
    }

    private String evaluarPalindroma(){
        String mensaje = "No es palindromo";
        if(palabra.equals(invertido)){
            mensaje = "Es palindromo";
        }
        return mensaje;
    }

    private void iniciarVistas() {
        TVResultado = findViewById(R.id.TVResultado);
        PTPalabra = findViewById(R.id.PTPalabra);
        BtnProcesar = findViewById(R.id.BtnProcesar);
        TVPalindroma = findViewById(R.id.TVPalindroma);
        BtnMensaje = findViewById(R.id.BtnMensaje);
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