package com.example.intentsimplicitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
    }

    public void Telefone(View v){
        Intent intent = new Intent(this, Telefone.class);
        startActivity(intent);
    }

    public void Mapa(View v){
        Intent intent = new Intent(this, Mapa.class);
        startActivity(intent);
    }

    public void Email(View v){
        Intent intent = new Intent(this, Email.class);
        startActivity(intent);
    }
}
