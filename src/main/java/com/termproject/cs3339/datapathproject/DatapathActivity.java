package com.termproject.cs3339.datapathproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.termproject.cs3339.instructions.Instruction;

public class DatapathActivity extends AppCompatActivity
{
    ImageView pathImages[];
    Instruction instruction;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datapath);

        //Get Input from last Screen
        Intent intent = getIntent();
        String name = intent.getStringExtra("com.termproject.cs3339.datapathproject.INSTRUCTION_NAME");
        int instructionType = intent.getIntExtra("com.termproject.cs3339.datapathproject.INSTRUCTION_TYPE", -1);
        String text = "Instruction " + name;

        TextView textView = (TextView) findViewById(R.id.textView);
        pathImages = getImageViews();

        instruction = new Instruction(instructionType);

        if(name.startsWith("~")) //Clicked on "Try it yourself"
        {
            name = name.substring(1, name.length());
            String createText = "Create Instruction " + name;
            textView.setText(createText);

            //Update instructions by touch and therefore imageviews

            //Have check button

        }
        else                            //Clicked on an instruction
        {
            textView.setText(text);
            //updateImageViews(InstructionSet.getSetPaths(instructionType));
        }
    }

    /**
     * Initialize ImageViews of each path image
     * @return
     */
    public ImageView[] getImageViews()
    {
        ImageView views[] = new ImageView[16];

   /*     views[0] = (ImageView) findViewById(R.id.path1);
        views[1] = (ImageView) findViewById(R.id.path2);
        views[2] = (ImageView) findViewById(R.id.path3);
        views[3] = (ImageView) findViewById(R.id.path4);
        views[4] = (ImageView) findViewById(R.id.path5);
        views[5] = (ImageView) findViewById(R.id.path6);
        views[6] = (ImageView) findViewById(R.id.path7);
        views[7] = (ImageView) findViewById(R.id.path8);
        views[8] = (ImageView) findViewById(R.id.path9);
        views[9] = (ImageView) findViewById(R.id.path10);
        views[10] = (ImageView) findViewById(R.id.path11);
        views[11] = (ImageView) findViewById(R.id.path12);
        views[12] = (ImageView) findViewById(R.id.path13);
        views[13] = (ImageView) findViewById(R.id.path14);
        views[14] = (ImageView) findViewById(R.id.path15);
        views[15] = (ImageView) findViewById(R.id.path16);*/

        return views;
    }

    public void updateImageViews(boolean[] pathValues)
    {
        for(int x = 0 ; x < pathValues.length ; x++)
        {
            if(pathValues[x] == true)
            {
                pathImages[x].setAlpha(1.0f);
            }
            else
            {
                pathImages[x].setAlpha(0.25f);
            }

        }
    }
}
