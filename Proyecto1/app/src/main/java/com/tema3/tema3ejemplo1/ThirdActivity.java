package com.tema3.tema3ejemplo1;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class ThirdActivity extends AppCompatActivity {
    private ImageButton imageButtonFinish;
    private Button button;
    private String nombre;
    private String mensaje;
    private int edad2;
    private String edad;
    private String compartir;

    // private final int PHONE_CALL_CODE = 100;
    //private final int PICTURE_FROM_CAMERA = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Tomar los datos del intent (NOMBRE)
        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
             nombre = bundle.getString("nombre");
             edad2 = bundle.getInt("edad");
             edad = String.valueOf(edad2);
             mensaje = bundle.getString("mensaje");
        }else{
            Toast.makeText(ThirdActivity.this,"ERROR",Toast.LENGTH_SHORT).show();

        }
        imageButtonFinish = (ImageButton)findViewById(R.id.imageButtonFinish);
        button = (Button)findViewById(R.id.buttonGoSharing);

        imageButtonFinish.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                imageButtonFinish.setVisibility(View.GONE);
                button.setVisibility(View.VISIBLE);
                if(mensaje.contentEquals("Saludo")){
                    Toast.makeText(ThirdActivity.this, "Hola " + nombre + " ¿Cómo llevas esos " + edad + " años?", Toast.LENGTH_SHORT).show();
                    compartir = "Hola " + nombre + " ¿Cómo llevas esos " + edad + " años?";
                }
                if(mensaje.contentEquals("Despedida")) {
                    Toast.makeText(ThirdActivity.this, "Espero verte pronto " + nombre + ", antes que cumplas " + edad + "...", Toast.LENGTH_SHORT).show();
                    compartir = "Espero verte pronto " + nombre + ", antes que cumplas " + edad + "...";

                }


            }


        });

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, compartir);
                startActivity(Intent.createChooser(intent, "Share with"));
            }

        });
    }




}
