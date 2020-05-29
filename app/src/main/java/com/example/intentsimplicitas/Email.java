package com.example.intentsimplicitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Email extends AppCompatActivity {

    EditText ediEmail1, ediEmail2, ediEmail3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        ediEmail1 = (EditText) findViewById(R.id.ediEmail);
        ediEmail2 = (EditText) findViewById(R.id.ediEmail2);
        ediEmail3 = (EditText) findViewById(R.id.ediEmail3);
        setTitle("Email");
    }

    public void enviarEmail(View view) throws UnsupportedEncodingException {

        String uriText =
                "mailto:" + ediEmail1.getText().toString() +
                        "?subject=" + URLEncoder.encode(ediEmail2.getText().toString(), "utf-8") +
                        "&body=" + URLEncoder.encode(ediEmail3.getText().toString(), "utf-8");
        Uri uri = Uri.parse(uriText);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(uri);
        startActivity(Intent.createChooser(intent, "Enviar Email"));

    }
}
