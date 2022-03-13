package com.example.practical18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText e1 = findViewById(R.id.e1);
        Button b1 = findViewById(R.id.button);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = e1.getText().toString();
                Intent intent =new Intent(Intent.ACTION_CALL);

                if(e1.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter Phone Number ", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    intent.setData(Uri.parse("tel:"+s));
                }
                if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this , "Please Grant Permission", Toast.LENGTH_SHORT).show();
                    permision();
                }
                else{
                    startActivity(intent);
                }

            }
        });




    }
    private void permision(){
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
    }
}

