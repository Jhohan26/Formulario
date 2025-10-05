package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class ConfirmActivity extends AppCompatActivity {

    private TextView tvNombre, tvFecha, tvTelefono, tvEmail, tvDescripcion;
    private MaterialButton btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        tvNombre = findViewById(R.id.tvNombre);
        tvFecha = findViewById(R.id.tvFecha);
        tvTelefono = findViewById(R.id.tvTelefono);
        tvEmail = findViewById(R.id.tvEmail);
        tvDescripcion = findViewById(R.id.tvDescripcion);
        btnEditar = findViewById(R.id.btnEditar);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String fecha = intent.getStringExtra("fecha");
        String telefono = intent.getStringExtra("telefono");
        String email = intent.getStringExtra("email");
        String descripcion = intent.getStringExtra("descripcion");

        tvNombre.setText(nombre);
        tvFecha.setText("Fecha Nacimiento: " + fecha);
        tvTelefono.setText("Tel: " + telefono);
        tvEmail.setText("Email: " + email);
        tvDescripcion.setText("Descripción: " + descripcion);

        btnEditar.setOnClickListener(v -> {
            Intent backIntent = new Intent(ConfirmActivity.this, MainActivity.class);
            backIntent.putExtra("nombre", nombre);
            backIntent.putExtra("fecha", fecha);
            backIntent.putExtra("telefono", telefono);
            backIntent.putExtra("email", email);
            backIntent.putExtra("descripcion", descripcion);
            startActivity(backIntent);
            finish();
        });
    }
}