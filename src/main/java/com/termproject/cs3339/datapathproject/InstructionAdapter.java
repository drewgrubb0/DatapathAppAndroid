package com.termproject.cs3339.datapathproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * An adaptor for the instructions path list that connects it to the ListView used in the MainActivity
 */
public class InstructionAdapter extends BaseAdapter
{
    /*Layout Inflator that */
    LayoutInflater mInstructionInflater;

    String[] names;
    String[] instructions;
    String[] descriptions;

    public InstructionAdapter(Context c, String[] names, String[] instructions, String[] descriptions)
    {
        this.names = names;
        this.instructions = instructions;
        this.descriptions = descriptions;

        mInstructionInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return names.length;
    }

    @Override
    public Object getItem(int index)
    {
        return names[index];
    }

    @Override
    public long getItemId(int index)
    {
        return index;
    }

    @Override
    public View getView(int index, View convertView, ViewGroup parent)
    {
        View view = mInstructionInflater.inflate(R.layout.paths_list_details, null);
        TextView nameTextView = (TextView) view.findViewById(R.id.nameTextView);
        TextView instructionTextView = (TextView) view.findViewById(R.id.instructionTextView);
        TextView descriptionTextView = (TextView) view.findViewById(R.id.descriptionTextView);

        String currentName = names[index];
        String currentInstruction = instructions[index];
        String currentDescription = descriptions[index];

        nameTextView.setText(currentName);
        instructionTextView.setText(currentInstruction);
        descriptionTextView.setText(currentDescription);

        return view;
    }
}
