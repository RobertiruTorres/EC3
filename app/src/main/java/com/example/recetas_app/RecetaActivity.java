package com.example.recetas_app;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecetaActivity extends AppCompatActivity {

    private TextView nombre;
    private TextView ingredientes;
    private TextView precio;
    private TextView preparacion;
    private TextView descripcion;

    private ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receta);

        nombre = findViewById(R.id.nombre);
        ingredientes = findViewById(R.id.ingredientes);
        precio = findViewById(R.id.precio);
        preparacion = findViewById(R.id.preparacion);
        descripcion = findViewById(R.id.descripcion);
        imagen = findViewById(R.id.imagen);


        nombre.setText(getIntent().getStringExtra("nombre"));
        ingredientes.setText(getIntent().getStringExtra("ingredientesPrincipales"));
        precio.setText("s/. "+getIntent().getStringExtra("precio"));
        preparacion.setText(getIntent().getStringExtra("preparacion"));
        descripcion.setText(getIntent().getStringExtra("descripcion"));

        int resourceId = getResources().getIdentifier(getIntent().getStringExtra("nombreImagen"), "drawable", getPackageName());
        imagen.setImageResource(resourceId);

    }
}