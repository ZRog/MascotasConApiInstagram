package com.proyecto.roger.mascotas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.proyecto.roger.mascotas.Presentador.IRecyclerViewFragmentPresenter;
import com.proyecto.roger.mascotas.Vista.RecyclerViewFragment;

public class ConfigurarCuenta extends AppCompatActivity {

    Toolbar toolbar;
    Button btn;
    IRecyclerViewFragmentPresenter presenter;
    EditText etCuenta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_cuenta);

        toolbar = (Toolbar) findViewById(R.id.miToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etCuenta = (EditText) findViewById(R.id.etCuenta);

        btn = (Button) findViewById(R.id.btnConfigurar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish();
               // presenter = new RecyclerViewFragmentPresenter(this,,"No");
                String cuenta = etCuenta.getText().toString();
                RecyclerViewFragment.cuenta = cuenta;
                RecyclerViewFragment.carga = true;


            }
        });

    }
}
