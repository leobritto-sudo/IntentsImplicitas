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
    EditText ediTelefone, ediTelefone1;
    Uri uri = null;
    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefone);

        txtTelefone = (TextView) findViewById(R.id.txtTelefone);
        btnTelefone = (Button) findViewById(R.id.btnTelefone);
        ediTelefone = (EditText) findViewById(R.id.ediTelefone);
        ediTelefone1 = (EditText) findViewById(R.id.ediTelefone1);
        setTitle("Telefone");
    }

    public void EnviarSMS(View v){
        uri = Uri.parse("sms: " + ediTelefone.getText());
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.putExtra("sms_body", ediTelefone1.getText().toString());
        startActivity(intent);
    }
}
