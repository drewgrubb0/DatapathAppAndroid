package com.termproject.cs3339.instructions;

import android.widget.ImageView;

public class Instruction
{
    private boolean paths[];

    /**
     * Create new instruction
     */
    public Instruction(ImageView[] views)
    {
        this.paths = new boolean[18];
    }

    /**
     * Sets the entire paths array to the passed instruction paths
     * @param newPaths the paths to be transferred over.
     */
    public void setPaths(boolean[] newPaths)
    {
        for(int x = 0 ; x < paths.length ; x++)
            this.paths[x] = newPaths[x];
    }

    /**
     * Sets boolean value of a particular index in paths
     * @param index the index of the path to change.
     */
    public void changeValue(int index)
    {
        paths[index] = !paths[index];
    }

    /**
     * @return boolean path array
     */
    public boolean[] getPaths()
    {
        return paths;
    }
}
