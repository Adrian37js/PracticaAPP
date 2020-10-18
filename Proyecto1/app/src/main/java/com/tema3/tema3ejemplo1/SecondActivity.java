package com.tema3.tema3ejemplo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;




public class SecondActivity extends AppCompatActivity {
    private TextView textView;
    private Button btnNext;
    private RadioButton RadioButtonsaludo_grupo;
    private RadioButton RadioButtondespedida_grupo;
    private TextView mostrarPorcentaje;
    private SeekBar seekBar;
    private String mensaje;
    private int edad;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Activar flecha ir atrás
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mostrarPorcentaje = (TextView)findViewById(R.id.textviewEdad);
        // SeekBar
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        // Valor Inicial
        seekBar.setProgress(18);
        // Valot Final
        seekBar.setMax(80);

        RadioButtonsaludo_grupo = (RadioButton) findViewById(R.id.saludo_grupo);
        RadioButtondespedida_grupo = (RadioButton) findViewById(R.id.despedida_grupo);

        btnNext = (Button) findViewById(R.id.buttonGoSharing);


        //Tomar los datos del intent (NOMBRE)
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            name = bundle.getString("name");
            Toast.makeText(SecondActivity.this,name,Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(SecondActivity.this,"ERROR",Toast.LENGTH_SHORT).show();

        }

        RadioButtonsaludo_grupo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                mensaje = RadioButtonsaludo_grupo.getText().toString();
                Toast.makeText(SecondActivity.this, mensaje, Toast.LENGTH_SHORT).show();

            }
        });

        RadioButtondespedida_grupo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                mensaje = RadioButtondespedida_grupo.getText().toString();
                Toast.makeText(SecondActivity.this, mensaje, Toast.LENGTH_SHORT).show();

            }


        });


        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    //hace un llamado a la perilla cuando se arrastra
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        mostrarPorcentaje.setText(String.valueOf(progress)+" años");
                    }
                    //hace un llamado  cuando se toca la perilla
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }
                    //hace un llamado  cuando se detiene la perilla
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });


        btnNext.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("mensaje", mensaje);
                intent.putExtra("edad", edad);
                intent.putExtra("nombre", name);
                startActivity(intent);

            }
        });
    }
}
