package com.example.intentsimplicitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Telefone extends AppCompatActivity {

    TextView txtTelefone;
    Button btnTelefone;
    EditText ediTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefone);

        txtTelefone = (TextView) findViewById(R.id.txtTelefone);
        btnTelefone = (Button) findViewById(R.id.btnTelefone);
        ediTelefone = (EditText) findViewById(R.id.ediTelefone);
    }

    public void EnviarSMS(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("sms:" + ediTelefone));
        intent.putExtra("sms_body", "Mensagem de boas vindas");
        startActivity(intent);
    }
}
