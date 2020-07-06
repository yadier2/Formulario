package com.example.miformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import java.util.Locale;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText campo_nombre,campo_telefono,campo_gmail,campo_DescripciónContacto;
    private EditText etFecha;
    private int ultimoAnio, ultimoMes, ultimoDiaDelMes;
    private DatePickerDialog.OnDateSetListener listenerDeDatePicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int anio, int mes, int diaDelMes) {
            ultimoAnio = anio;
            ultimoMes = mes;
            ultimoDiaDelMes = diaDelMes;
            refrescarFechaEnEditText();
        }
    };
    public void refrescarFechaEnEditText() {
        // Formateamos la fecha ;)
        String fecha = String.format(Locale.getDefault(), "%02d-%02d-%02d", ultimoAnio, ultimoMes+1, ultimoDiaDelMes);
        etFecha.setText(fecha); }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////7777
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campo_nombre = findViewById(R.id.campo_nombre);
        etFecha = findViewById(R.id.etFecha);
        campo_telefono = findViewById(R.id.campo_telefono);
        campo_gmail = findViewById(R.id.campo_gmail);
        campo_DescripciónContacto =findViewById(R.id.campo_DescripciónContacto);

        Intent intent = getIntent();
        campo_nombre.setText(intent.getStringExtra("name"));
        etFecha.setText(intent.getStringExtra("dates"));
        campo_telefono.setText(intent.getStringExtra("telephone"));
        campo_gmail.setText(intent.getStringExtra("mail"));
        campo_DescripciónContacto.setText(intent.getStringExtra("description"));



        // Poner último año, mes y día a la fecha de hoy
        final Calendar calendario = Calendar.getInstance();
        ultimoAnio = calendario.get(Calendar.YEAR);
        ultimoMes = calendario.get(Calendar.MONTH);
        ultimoDiaDelMes = calendario.get(Calendar.DAY_OF_MONTH);

        // Hacer que el datepicker se muestre cuando toquen el EditText;
        etFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialogoFecha = new DatePickerDialog(MainActivity.this, listenerDeDatePicker, ultimoAnio, ultimoMes, ultimoDiaDelMes);
                dialogoFecha.show();
            }
        });
     
    }

    public void validar(View v){

              Intent intent= new Intent(MainActivity.this,ConfirmarDatos.class);

        intent.putExtra("nombre",campo_nombre.getText().toString());
        intent.putExtra("fecha",etFecha.getText().toString());
        intent.putExtra("telefono",campo_telefono.getText().toString());
        intent.putExtra("gmail",campo_gmail.getText().toString());
        intent.putExtra("descripcion",campo_DescripciónContacto.getText().toString());
        finish();
        startActivity(intent);
    }

}