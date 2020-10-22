package com.example.spartangaming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Membrecias;

public class Clientes extends AppCompatActivity {

    private Spinner spin1, spin2;
    private EditText edit;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        spin1 = (Spinner)findViewById(R.id.spnClientes);
        spin2 = (Spinner)findViewById(R.id.spnPlanes);
        edit = (EditText)findViewById(R.id.et1);
        text = (TextView)findViewById(R.id.tv);

        // Recibir el dato.
        // <----
        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayList<String> listaMembrecias = (ArrayList<String>) getIntent().getSerializableExtra("listaMembrecias");


        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        ArrayAdapter<String> adapts = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaMembrecias);

        spin1.setAdapter(adapt);
        spin2.setAdapter(adapts);
    }

    public void Calcular(View v)
    {
        String cliente = spin1.getSelectedItem().toString();  // almaceno selección del spinner.
        String membrecias = spin2.getSelectedItem().toString();

        Membrecias plan = new Membrecias();  // Construir mi objeto.

        int saldo = Integer.parseInt(edit.getText().toString());

        int resultPlus = saldo - plan.getPlus();
        int resultPlusultra = saldo - plan.getPlusUltra();

        // Inteligencia Roberto.

        if(cliente.equals("Roberto") && membrecias.equals("Plus"))
        {
            text.setText("El precio del plan es: " + resultPlus);
        }

        if(cliente.equals("Roberto") && membrecias.equals("PlusUltra"))
        {
            text.setText("El precio del plan es: " + resultPlusultra);
        }

        // Inteligencia para Ivan.

        if(cliente.equals("Ivan") && membrecias.equals("Plus"))
        {
            text.setText("El precio del plan es: " + resultPlus);
        }

        if(cliente.equals("Ivan") && membrecias.equals("PlusUltra"))
        {
            text.setText("El precio del plan es: " + resultPlusultra);
        }

        if(cliente.equals("Claudio") && membrecias.equals("Plus"))
        {
            text.setText("El precio del plan es: " + resultPlus);
        }

        if(cliente.equals("Claudio") && membrecias.equals("PlusUltra"))
        {
            text.setText("El precio del plan es: " + resultPlusultra);
        }

        if(cliente.equals("Maria") && membrecias.equals("Plus"))
        {
            text.setText("El precio del plan es: " + resultPlus);
        }

        if(cliente.equals("Maria") && membrecias.equals("PlusUltra"))
        {
            text.setText("El precio del plan es: " + resultPlusultra);
        }
    }
}