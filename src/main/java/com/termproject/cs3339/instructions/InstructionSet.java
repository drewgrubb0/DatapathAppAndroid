package com.termproject.cs3339.instructions;

import java.util.Arrays;

public class InstructionSet
{
    private static final int TYPE_ALU = 0;
    private static final int TYPE_LOAD = 1;
    private static final int TYPE_STORE = 2;
    private static final int TYPE_BRANCH = 3;

    private static final boolean[] ALU_INSTRUCTION = {};
    private static final boolean[] LOAD_INSTRUCTION = {};
    private static final boolean[] STORE_INSTRUCTION = {};
    private static final boolean[] BRANCH_INSTRUCTION = {};

    /**
     * Checks to see if an instruction is equal to the type of instruction
     * sent via type.
     * @param instruction instruction to be checked
     * @param type type of instruction it is
     * @return
     */
    public static boolean equals(Instruction instruction, int type)
    {
        switch(type)
        {
            case TYPE_ALU:
                return Arrays.equals(instruction.getPaths(), ALU_INSTRUCTION);
            case TYPE_LOAD:
                return Arrays.equals(instruction.getPaths(), LOAD_INSTRUCTION);
            case TYPE_STORE:
                return Arrays.equals(instruction.getPaths(), STORE_INSTRUCTION);
            case TYPE_BRANCH:
                return Arrays.equals(instruction.getPaths(), BRANCH_INSTRUCTION);
            default:
                return Arrays.equals(instruction.getPaths(), new boolean[16]);
        }
    }

    /**
     * Gets the path instruction of the given instruction type
     * @param type
     * @return
     */
    public static boolean[] getSetPaths(int type)
    {
        switch(type)
        {
            case TYPE_ALU:
                return ALU_INSTRUCTION;
            case TYPE_LOAD:
                return LOAD_INSTRUCTION;
            case TYPE_STORE:
                return STORE_INSTRUCTION;
            case TYPE_BRANCH:
                return BRANCH_INSTRUCTION;
            default:
                return new boolean[16];
        }
    }
}
