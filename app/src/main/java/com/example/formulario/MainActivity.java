package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.button.MaterialButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText etNombre, etFechaNacimiento, etTelefono, etEmail, etDescripcion;
    private MaterialButton btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        etFechaNacimiento = findViewById(R.id.etFechaNacimiento);
        etTelefono = findViewById(R.id.etTelefono);
        etEmail = findViewById(R.id.etEmail);
        etDescripcion = findViewById(R.id.etDescripcion);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        // Fecha de nacimiento con DatePicker
        etFechaNacimiento.setOnClickListener(v -> {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                    (view, year1, monthOfYear, dayOfMonth) ->
                            etFechaNacimiento.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year1),
                    year, month, day);
            datePickerDialog.show();
        });

        // Revisar si hay datos enviados para precargar
        if (getIntent() != null && getIntent().hasExtra("nombre")) {
            etNombre.setText(getIntent().getStringExtra("nombre"));
            etFechaNacimiento.setText(getIntent().getStringExtra("fecha"));
            etTelefono.setText(getIntent().getStringExtra("telefono"));
            etEmail.setText(getIntent().getStringExtra("email"));
            etDescripcion.setText(getIntent().getStringExtra("descripcion"));
        }

        btnSiguiente.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);
            intent.putExtra("nombre", etNombre.getText().toString());
            intent.putExtra("fecha", etFechaNacimiento.getText().toString());
            intent.putExtra("telefono", etTelefono.getText().toString());
            intent.putExtra("email", etEmail.getText().toString());
            intent.putExtra("descripcion", etDescripcion.getText().toString());
            startActivity(intent);
        });
    }
}