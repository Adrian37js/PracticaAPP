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
    private EditText editTextPhone;
    private EditText editTextWeb;
    private ImageButton imageButtonFinish;
    private Button button;

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
            String nombre = bundle.getString("nombre");
            String edad = bundle.getString("edad");
            String mensaje = bundle.getString("mensaje");
            Toast.makeText(ThirdActivity.this,nombre,Toast.LENGTH_SHORT).show();
            Toast.makeText(ThirdActivity.this,edad,Toast.LENGTH_SHORT).show();
            Toast.makeText(ThirdActivity.this,mensaje,Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(ThirdActivity.this,"ERROR",Toast.LENGTH_SHORT).show();

        }

        imageButtonFinish = (ImageButton)findViewById(R.id.imageButtonFinish);

        button = (Button)findViewById(R.id.buttonGoSharing);
        //int user_activity1 = getIntent().getExtra("nombre");

        imageButtonFinish.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                imageButtonFinish.setVisibility(View.GONE);
                button.setVisibility(View.VISIBLE);
                //Toast.makeText(ThirdActivity.this, "Hola"++"¿Cómo llevas esos "++" años?", Toast.LENGTH_SHORT).show();


            }


        });



// Pasaremos de la actividad actual a OtraActivity

    }




}
