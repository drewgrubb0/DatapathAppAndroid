package com.termproject.cs3339.datapathproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.termproject.cs3339.instructions.Instruction;
import com.termproject.cs3339.instructions.InstructionSet;

public class DatapathActivity extends AppCompatActivity implements View.OnClickListener
{
    ImageView pathImages[];
    Instruction instruction;
    boolean canEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datapath);
        Intent intent = getIntent();

        String name = intent.getStringExtra("com.termproject.cs3339.datapathproject.INSTRUCTION_NAME");
        String text = "Instruction " + name;
        TextView textView = findViewById(R.id.textView);
        textView.setText(text);

        final int instructionType = intent.getIntExtra("com.termproject.cs3339.datapathproject.INSTRUCTION_TYPE", -1);
        pathImages = getImageViews();
        instruction = new Instruction(pathImages);

        if(name.startsWith("~")) //Clicked on "Try it yourself"
        {
            canEdit = true;
            name = name.substring(1, name.length());
            String createText = "Create Instruction " + name;
            textView.setText(createText);

            final TextView feedbackText = findViewById(R.id.feedbackText);
            feedbackText.setVisibility(View.VISIBLE);

            Button checkButton = findViewById(R.id.checkButton);
            checkButton.setVisibility(View.VISIBLE);
            checkButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    String feedback;
                    if(InstructionSet.equals(instruction, instructionType))
                        feedback = "You did it!";
                    else
                        feedback = "Sorry, try again.";
                    feedbackText.setText(feedback);
                }
            });
        }
        else
        {
            instruction.setPaths(InstructionSet.getSetPaths(instructionType));
            updateImageViews(instruction.getPaths());
        }
    }

    /**
     * Initialize ImageViews of each path image and their clicklisteners
     * @return the
     */
    public ImageView[] getImageViews()
    {
        ImageView views[] = new ImageView[18];

        views[0] = findViewById(R.id.path1);
        views[1] = findViewById(R.id.path2);
        views[2] = findViewById(R.id.path3);
        views[3] = findViewById(R.id.path4);
        views[4] = findViewById(R.id.path5);
        views[5] = findViewById(R.id.path6);
        views[6] = findViewById(R.id.path7);
        views[7] = findViewById(R.id.path8);
        views[8] = findViewById(R.id.path9);
        views[9] = findViewById(R.id.path10);
        views[10] = findViewById(R.id.path11);
        views[11] = findViewById(R.id.path12);
        views[12] = findViewById(R.id.path13);
        views[13] = findViewById(R.id.path14);
        views[14] = findViewById(R.id.path15);
        views[15] = findViewById(R.id.path16);
        views[16] = findViewById(R.id.path17);
        views[17] = findViewById(R.id.path18);

        for(int x = 0 ; x < views.length ; x++)
            views[x].setOnClickListener(this);

        return views;
    }

    /**
     * Updates the images within the layout to change their transparency based on if they are
     * "enabled" within the instruction.
     * @param pathValues
     */
    public void updateImageViews(boolean[] pathValues)
    {
        for(int x = 0 ; x < pathValues.length ; x++)
        {
            if(pathValues[x])
                pathImages[x].setAlpha(1.0f);
            else
                pathImages[x].setAlpha(0.25f);
        }
    }

    @Override
    public void onClick(View v)
    {
        if(canEdit)
        {
            for(int x = 0 ; x < pathImages.length ; x++)
            {
                if(v.getId() == pathImages[x].getId())
                {
                    instruction.changeValue(x);
                    updateImageViews(instruction.getPaths());
                    return;
                }
            }
        }
    }
}
