package com.example.android.feelthephoto;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.util.BitSet;

public class MainActivity extends AppCompatActivity {
    Button but1;
    ImageButton but2;
    Intent intent;
    final static int pickbycamera = 10;
    ImageView img;
    Bitmap bitmp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but1 = findViewById(R.id.but1);
        but2 = findViewById(R.id.but2);
        img = findViewById(R.id.img);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getApplicationContext().setWallpaper(bitmp);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,pickbycamera);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.item1:
                Toast.makeText(MainActivity.this, "1st", Toast.LENGTH_LONG).show();
                break;
            case R.id.item2:
                Toast.makeText(MainActivity.this, "2nd", Toast.LENGTH_LONG).show();
                break;

            case R.id.item3:
                Toast.makeText(MainActivity.this, "3rd", Toast.LENGTH_LONG).show();
                break;
        }

        return  super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK)
        {
            Bundle extras=data.getExtras();
            bitmp=(Bitmap)extras.get("data");
                    img.setImageBitmap(bitmp);
        }
    }
}
