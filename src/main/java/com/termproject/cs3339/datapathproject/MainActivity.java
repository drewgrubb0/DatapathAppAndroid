package com.termproject.cs3339.datapathproject;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
{
    ListView pathList;
    String[] names;
    String[] instructions;
    String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        pathList = (ListView) findViewById(R.id.pathList);

        names = res.getStringArray(R.array.names);
        instructions = res.getStringArray(R.array.instructions);
        descriptions = res.getStringArray(R.array.descriptions);

        InstructionAdapter instructionAdapter = new InstructionAdapter(this, names, instructions, descriptions);
        pathList.setAdapter(instructionAdapter);

        pathList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int index, long id)
            {
                Intent showPathDisplay = new Intent(getApplicationContext(), DatapathActivity.class);
                showPathDisplay.putExtra("com.termproject.cs3339.datapathproject.INSTRUCTION_TO_SHOW", index);
                startActivity(showPathDisplay);
            }
        });


    }
}
