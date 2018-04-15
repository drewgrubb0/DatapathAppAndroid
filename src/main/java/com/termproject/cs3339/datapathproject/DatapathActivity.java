package com.termproject.cs3339.datapathproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;

public class DatapathActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datapath);

        Intent intent = getIntent();
        int state = intent.getIntExtra("com.termproject.cs3339.datapathproject.INSTRUCTION_TO_SHOW", -1);
        String text = "You clicked item: " + state;

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(text);
    }
}
