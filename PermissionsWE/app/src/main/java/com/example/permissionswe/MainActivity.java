package com.example.permissionswe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mbtn;
    private static int REQ_CODE=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtn=findViewById(R.id.btnRequestPermission);
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String []permission={Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.CAMERA};
                ActivityCompat.requestPermissions(MainActivity.this,permission,REQ_CODE);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @org.jetbrains.annotations.NotNull String[] permissions, @NonNull @org.jetbrains.annotations.NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]== PackageManager.PERMISSION_GRANTED&&grantResults[1]==PackageManager.PERMISSION_GRANTED)
        {
            shown("granted");
        }
        else if(grantResults[0]== PackageManager.PERMISSION_GRANTED&&grantResults[1]==PackageManager.PERMISSION_DENIED)
        {

                shown("storage granted Camera Denied");
        }
        else if(grantResults[0]== PackageManager.PERMISSION_DENIED&&grantResults[1]==PackageManager.PERMISSION_GRANTED)
        {
            shown("Camera granted storage denied");
        }
        else
        {
            shown("both denied");;
        }
    }
    public void shown(String massage)
    {
        Toast.makeText(this,massage,Toast.LENGTH_SHORT).show();
    }
}