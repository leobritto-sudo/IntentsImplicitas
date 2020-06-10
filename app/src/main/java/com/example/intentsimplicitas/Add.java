package com.example.intentsimplicitas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Add extends AppCompatActivity {

    private static final int PickImage = 1234;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        setTitle("Galeria");
    }

    public void ViewGallery(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(Intent.createChooser(intent, "Selecione uma imagem"), PickImage);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PickImage) {
            if (resultCode == RESULT_OK) {
                Uri extras = data.getData();
                ImageView imageView = new ImageView(this);
                imageView.setImageURI(extras);
                LinearLayout ln = (LinearLayout) findViewById(R.id.ln);
                ln.addView(imageView);
                imageView.getLayoutParams().height = 100;
                imageView.getLayoutParams().width = 100;
                imageView.requestLayout();
                showMessage("Imagem capturada!");
            } else {
                showMessage("Imagem não capturada!");
            }
        }
    }

    private void showMessage(String msg) {
        Toast.makeText(this, msg,
                Toast.LENGTH_LONG)
                .show();
    }
}
