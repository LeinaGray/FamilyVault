package com.sppdev.familyvault;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void getFirstName(View v){
        EditText t = findViewById(R.id.first_name);
        String input = t.getText().toString();
        ((TextView)findViewById(R.id.display)).setText(input);

        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
        Log.d(null, "onCreate called.");

    }
}