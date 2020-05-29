package com.example.intentsimplicitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Mapa extends AppCompatActivity {

    TextView txtMapa;
    Button btnMapa;
    EditText ediMapa;
    Uri uri = null;
    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        txtMapa = (TextView) findViewById(R.id.txtMapa);
        btnMapa = (Button) findViewById(R.id.btnMapa);
        ediMapa = (EditText) findViewById(R.id.ediMapa);
        setTitle("Mapa");
    }

    public void BuscarEndereco(View v){
        uri = Uri.parse("geo:0,0?q= " + ediMapa.getText());
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
