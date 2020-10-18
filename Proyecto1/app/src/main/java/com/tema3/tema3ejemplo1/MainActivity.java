package com.tema3.tema3ejemplo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private EditText editTextUsuario;
    private String usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Forzar y cargar icono en el Action Bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.icono_app);


        TextView text = new TextView(getApplicationContext());
        text.setPadding(10,10,10,10);

        editTextUsuario = (EditText) findViewById(R.id.Usuario);
         usuario = editTextUsuario.getText().toString();

        btn = (Button)findViewById(R.id.buttonMain);

        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //Acceder al segundo activity y mandar un String

                if(editTextUsuario.getText().toString()!=null || !editTextUsuario.getText().toString().isEmpty()) {
                     usuario = editTextUsuario.getText().toString();
                    //Intent explícito, se le indica dónde se quiere ir
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("name",usuario);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Nombre vacio ", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

}
