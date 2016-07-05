package com.proyecto.roger.mascotas.Mail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.proyecto.roger.mascotas.R;

public class Contacto extends AppCompatActivity {

    Toolbar toolbar;
    Button btnCorreo;
    EditText etDestino,etAsunto,etMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        toolbar = (Toolbar) findViewById(R.id.miToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etDestino = (EditText) findViewById(R.id.destinoCorreo);
        etAsunto = (EditText) findViewById(R.id.asuntoCorreo);
        etMensaje = (EditText) findViewById(R.id.mensajeCorreo);

        btnCorreo = (Button) findViewById(R.id.btnCorreo);
        btnCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    private void sendEmail(){
        String email = etDestino.getText().toString().trim();
        String subject = etAsunto.getText().toString().trim();
        String message = etMensaje.getText().toString().trim();

        SendMail sm = new SendMail(this, email, subject, message);

        sm.execute();
    }
}
