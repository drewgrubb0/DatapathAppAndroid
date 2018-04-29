package com.termproject.cs3339.instructions;

public class Instruction
{
    private boolean paths[];
    private int type;

    /**
     * Create new instruction
     * @param type the type of instruction this instruction will become
     */
    public Instruction(int type)
    {
        this.type = type;
        this.paths = new boolean[16];
    }

    /**
     * Sets boolean value of a particular index in paths
     * @param index
     * @param val
     */
    public void setValue(int index, boolean val)
    {
        paths[index] = val;
    }

    /**
     * @return boolean path array
     */
    public boolean[] getPaths()
    {
        return paths;
    }
}
