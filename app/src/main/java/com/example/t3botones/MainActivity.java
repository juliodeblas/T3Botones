package com.example.t3botones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {

    ImageButton boton;
    ToggleButton toggleButton;
    Switch aSwitchNormal;
    CheckBox checkBoxNormal;
    RadioGroup grupoRadios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }


    private void instancias() {
        boton = findViewById(R.id.botonImagen);
        toggleButton = findViewById(R.id.togImagen);
        aSwitchNormal = findViewById(R.id.switch_normal);
        checkBoxNormal = findViewById(R.id.check_normal);
        grupoRadios = findViewById(R.id.grupo_radios);
    }

    private void acciones() {
        boton.setOnClickListener(this);
        toggleButton.setOnCheckedChangeListener(this);
        aSwitchNormal.setOnCheckedChangeListener(this);
        checkBoxNormal.setOnCheckedChangeListener(this);
        grupoRadios.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.botonImagen:
                //Log.v("tag", String.valueOf(toggleButton.isChecked()));
                RadioButton rSel =  findViewById(grupoRadios.getCheckedRadioButtonId());
                Toast.makeText(getApplicationContext(), rSel.getText(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.togImagen:
                break;
            case R.id.switch_normal:
                break;
            case R.id.check_normal:
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        String elemento = "";
        boolean estado = false;

        switch (buttonView.getId()) {
            case R.id.check_normal:
                elemento = "check";
                estado = isChecked;
                break;
            case R.id.togImagen:
                if (isChecked) {
                    boton.setEnabled(true);
                } else {
                    boton.setEnabled(false);
                }
                elemento = "toggle";
                estado = isChecked;
                break;
            case R.id.switch_normal:
                elemento = "switch";
                estado = isChecked;
                break;
        }

        Toast.makeText(getApplicationContext(), String.format("El elemento %s esta en estado %b", elemento, estado), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        String elemento = "";

        switch (i){
            case R.id.radio1:
                elemento = "opcion 1";
                break;
            case R.id.radio2:
                elemento = "opcion 2";
                break;
            case R.id.radio3:
                elemento = "opcion 3";
                break;
        }

        Toast.makeText(getApplicationContext(), elemento, Toast.LENGTH_SHORT).show();
    }
}
