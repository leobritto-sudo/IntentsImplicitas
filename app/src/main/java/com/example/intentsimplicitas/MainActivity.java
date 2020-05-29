package com.example.intentsimplicitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Menu Principal");
    }

    public void Telefone(View v){
        Intent intent = new Intent(MainActivity.this, Telefone.class);
        startActivity(intent);
    }

    public void Mapa(View v){
        Intent intent1 = new Intent(MainActivity.this, Mapa.class);
        startActivity(intent1);
    }

    public void Email(View v){
        Intent intent2 = new Intent(MainActivity.this, Email.class);
        startActivity(intent2);
    }
}
