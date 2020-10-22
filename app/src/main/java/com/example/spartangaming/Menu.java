package com.example.spartangaming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    private ViewFlipper vf;
    private int[] images = {R.drawable.a, R.drawable.b, R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        vf = (ViewFlipper)findViewById(R.id.slider);

        for(int i = 0; i < images.length; i++)
        {
            flip_image(images[i]);
        }
    }


    // función que me permitirá configurar el slider
    public void flip_image(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view);           // añadimos al viewflipper el contenido del slider
        vf.setFlipInterval(2800);   // duración intervalo de imagenes
        vf.setAutoStart(true);     // inicia de forma automatica.

        // Sentido al slider
        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }


    // Intent Explícito.

    public void Maps(View v)
    {
        Intent i = new Intent(this, Maps.class);
        startActivity(i);
    }

    public void Info(View v)
    {
        Intent i = new Intent(this, Info.class);
        startActivity(i);
    }

    public void Clientes(View v)
    {
        // Envío el dato

        ArrayList<String> clientes = new ArrayList<String>();
        ArrayList<String> membrecias = new ArrayList<String>();

        clientes.add("Roberto");
        clientes.add("Ivan");
        clientes.add("Claudio");
        clientes.add("Maria");

        membrecias.add("Plus");
        membrecias.add("PlusUltra");

        Intent i = new Intent(this, Clientes.class);
        i.putExtra("listaClientes", clientes); // preparo el dato que quiero envíar.
        i.putExtra("listaMembrecias", membrecias);
        startActivity(i);
    }
}