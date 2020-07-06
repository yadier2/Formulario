package com.example.miformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {
        TextView nombre1,telefono1,gmail1,descripcion1;
        TextView fecha1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        recibirDatos();
    }

    private void recibirDatos(){
        Bundle extras =  getIntent().getExtras();
        String nombre = extras.getString("nombre");
        String fecha = extras.getString("fecha");
        String telefono = extras.getString("telefono");
        String gmail = extras.getString("gmail");
        String descripcion = extras.getString("descripcion");

        nombre1 =(TextView)findViewById(R.id.nombre1);
        fecha1 =(TextView)findViewById(R.id.fecha1);
        telefono1 =(TextView)findViewById(R.id.telefono1);
        gmail1 =(TextView)findViewById(R.id.gmail1);
        descripcion1 =(TextView)findViewById(R.id.descripcion1);

        nombre1.setText(nombre );
        fecha1.setText(fecha);
        telefono1.setText(telefono);
        gmail1.setText(gmail);
        descripcion1.setText(descripcion);
    }


    public void validar1(View v){

        Intent intent= new Intent(ConfirmarDatos.this,MainActivity.class);
        intent.putExtra("name",nombre1.getText().toString());
        intent.putExtra("dates",fecha1.getText().toString());
        intent.putExtra("telephone",telefono1.getText().toString());
        intent.putExtra("mail",gmail1.getText().toString());
        intent.putExtra("description",descripcion1.getText().toString());
        finish();
        startActivity(intent);
    }

}