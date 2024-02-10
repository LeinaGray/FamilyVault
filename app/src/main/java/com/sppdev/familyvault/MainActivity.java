package com.sppdev.familyvault;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    RecyclerView family_member_list;
    FloatingActionButton add_family_member;
    Button signup;
    EditText first_name, middle_name, last_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void getFirstName(View v){
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
        Log.d(null, "onCreate called.");

        first_name = findViewById(R.id.first_name);
        middle_name = findViewById(R.id.middle_name);
        last_name = findViewById(R.id.last_name);
        signup = findViewById(R.id.add_family_member);
                try {
                    DatabaseHelper mydb = new DatabaseHelper(MainActivity.this);
                    mydb.addMember(first_name.getText().toString().trim(),
                            middle_name.getText().toString().trim(),
                            last_name.getText().toString().trim());
                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                };

        showFamilyList(v);



    }

    public void showFamilyList(View v) {
        setContentView(R.layout.family_members);

    }

    public void addFamilyMember(View v) {
        family_member_list = findViewById(R.id.family_member_list);
        add_family_member = findViewById(R.id.add_family_member);

    }
}