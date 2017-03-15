package com.gabo.weightless;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class createEquipment extends AppCompatActivity {
    private EditText nameInput;
    private String user;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_equipment);

        nameInput = (EditText) findViewById(R.id.nameInput);

        Intent i = getIntent();
        user = i.getStringExtra("user");

        dbHelper = new DBHelper(this);

        Button createEquipmentButton = (Button) findViewById(R.id.createButton);
        createEquipmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEquipment(v);
            }
        });
    }

    public void createEquipment(View v){
        String name = nameInput.getText().toString();
        if(name.length() > 0){
            if(!dbHelper.equipmentExists(name)){
                dbHelper.createEquipment(user, name);
                Intent i  = new Intent();
                setResult(Activity.RESULT_OK, i);
                finish();
            }else{
                Toast.makeText(this, "This Equipment already exists, choose a new name", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "You have to fill the input box to continue", Toast.LENGTH_SHORT).show();
        }
    }
}
