package com.example.intentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button btnCall;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edittxt);
        btnCall = findViewById(R.id.btn_call);
        btnSend = findViewById(R.id.btn_send);



        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringToPass = editText.getText().toString().trim();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, stringToPass);
                intent.setType("text/plain");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Cannot handle the intent", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringToPass = editText.getText().toString().trim();

                Intent intentCall = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+stringToPass));
//                intent.putExtra(Intent.EXTRA_TEXT, "tel : "+stringToPass);
//                intentCall.setData(Uri.parse("tel:"+stringToPass));
                startActivity(intentCall);


            }
        });



    }
}