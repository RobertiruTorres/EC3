package com.example.recetas_app;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class PlatosActivity extends AppCompatActivity {

    private ListView platosListView;
    private List<Plato> platosList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platos);

        platosListView = findViewById(R.id.platosListView);
        platosList = new ArrayList<>();

        loadPlatosFromJson();
        displayPlatos();
    }

    private void loadPlatosFromJson() {
        try {
            String jsonFileName = "data.json";
            JSONObject jsonObject = loadJsonFromAssets(jsonFileName);

            if (jsonObject != null) {
                JSONArray platosArray = jsonObject.getJSONArray("platos");

                for (int i = 0; i < platosArray.length(); i++) {
                    JSONObject platoObject = platosArray.getJSONObject(i);

                    String nombreImagen = platoObject.getString("nombreImagen");
                    String nombre = platoObject.getString("nombre");
                    String descripcion = platoObject.getString("descripcion");
                    String ingredientesPrincipales = platoObject.getString("ingredientesPrincipales");
                    String preparacion = platoObject.getString("preparacion");
                    String precio = platoObject.getString("precio");

                    Plato plato = new Plato(nombreImagen, nombre, descripcion, ingredientesPrincipales, preparacion, precio);
                    platosList.add(plato);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void displayPlatos() {
        ArrayAdapter<Plato> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, platosList);
        platosListView.setAdapter(adapter);

        // Set the OnItemClickListener to handle clicks on ListView items
        platosListView.setOnItemClickListener((parent, view, position, id) -> {
            Plato selectedPlato = platosList.get(position);

            // Start the DetallesPlatoActivity and pass the selected plato
            Intent intent = new Intent(PlatosActivity.this, RecetaActivity.class);
            intent.putExtra("nombre", selectedPlato.nombre);
            intent.putExtra("descripcion", selectedPlato.descripcion);
            intent.putExtra("ingredientesPrincipales", selectedPlato.ingredientesPrincipales);
            intent.putExtra("preparacion", selectedPlato.preparacion);
            intent.putExtra("precio", selectedPlato.precio);
            intent.putExtra("nombreImagen", selectedPlato.nombreImagen);
            startActivity(intent);
        });
    }

    private JSONObject loadJsonFromAssets(String fileName) {
        try {
            AssetManager assetManager = getAssets();
            InputStream inputStream = assetManager.open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            String jsonString = new String(buffer, StandardCharsets.UTF_8);
            return new JSONObject(jsonString);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


}
