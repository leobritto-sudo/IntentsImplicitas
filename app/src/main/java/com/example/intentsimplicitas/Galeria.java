package com.example.intentsimplicitas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Galeria extends AppCompatActivity {

    private static final int TakePic = 1;
    private Uri uri;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);
    }

    public void takePic(View v) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, TakePic);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TakePic) {
            if (resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                ImageView imageView = new ImageView(this);
                imageView.setImageBitmap(imageBitmap);
                LinearLayout ln = (LinearLayout) findViewById(R.id.ln);
                ln.addView(imageView);
                imageView.getLayoutParams().height = 100;
                imageView.getLayoutParams().width = 100;
                imageView.requestLayout();
                showMessage("Imagem capturada!");
                addPic();
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

    private void addPic() {
        Intent intent = new Intent(
                Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(uri);
        this.sendBroadcast(intent);
    }
}

