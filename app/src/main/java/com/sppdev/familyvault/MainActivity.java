package com.sppdev.familyvault;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    RecyclerView family_member_list;
    FloatingActionButton add_family_member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void getFirstName(View v){
        EditText t = findViewById(R.id.first_name);
        String input = t.getText().toString();
        ((TextView)findViewById(R.id.display)).setText(input);

        showFamilyList(v);


        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
        Log.d(null, "onCreate called.");
    }

    public void showFamilyList(View v) {
        setContentView(R.layout.family_members);

    }

    public void addFamilyMember(View v) {
        family_member_list = findViewById(R.id.family_member_list);
        add_family_member = findViewById(R.id.add_family_member);

    }
}