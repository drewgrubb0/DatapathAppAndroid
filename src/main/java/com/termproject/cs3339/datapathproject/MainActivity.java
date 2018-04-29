package com.termproject.cs3339.datapathproject;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    ListView pathList;
    String[] names;
    String[] instructions;
    String[] descriptions;
    String[] types;

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
        types = res.getStringArray(R.array.types);

        InstructionAdapter instructionAdapter = new InstructionAdapter(this, names, instructions, descriptions);
        pathList.setAdapter(instructionAdapter);

        pathList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int index, long id)
            {
                Intent showPathDisplay = new Intent(getApplicationContext(), DatapathActivity.class);
                showPathDisplay.putExtra("com.termproject.cs3339.datapathproject.INSTRUCTION_NAME", names[index]);
                showPathDisplay.putExtra("com.termproject.cs3339.datapathproject.INSTRUCTION_TYPE", types[index]);
                startActivity(showPathDisplay);
            }
        });

        Button learnMoreButton = (Button) findViewById(R.id.learnMoreButton);
        learnMoreButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String link = "http://www.cise.ufl.edu/~mssz/CompOrg/CDA-proc.html";
                Uri address = Uri.parse(link);

                Intent travelIntent = new Intent(Intent.ACTION_VIEW, address);

                if(travelIntent.resolveActivity(getPackageManager()) != null)
                {
                    startActivity(travelIntent);
                }
            }
        });

        Button tryItNowButton = (Button) findViewById(R.id.tryItYourself);
        tryItNowButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Sends to DataPathActivity with a random instruction
                Random random = new Random();
                int itemIndex = random.nextInt(instructions.length);

                Intent showPathDisplay = new Intent(getApplicationContext(), DatapathActivity.class);
                showPathDisplay.putExtra("com.termproject.cs3339.datapathproject.INSTRUCTION_NAME", "~" + names[itemIndex]);
                showPathDisplay.putExtra("com.termproject.cs3339.datapathproject.INSTRUCTION_TYPE", "~" + types[itemIndex]);
                startActivity(showPathDisplay);
            }
        });
    }
}
