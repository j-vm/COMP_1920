package Ccode.CodeBlocks;

import Ccode.CodeBlock;

import java.io.FileOutputStream;
import java.io.IOException;

public class CodeRoot extends CodeBlock {
    private int numOfInputs;
    public CodeRoot(int numOfInputs) {
        super(0, 0, 0, 0);
        this.numOfInputs = numOfInputs;
    }

    @Override
    public String output(){

        String header="";
        String inputAssignment="";

        switch (this.numOfInputs){
            case 0:
                header = "int generated(int memory)";
                break;
            case 1:
                header = "int generated(int first_arg)";
                inputAssignment = "\tregisters[5] = first_arg;\n";
                break;
            case 2:
                header = "int generated(int first_arg, int second_arg)";
                inputAssignment = "\tregisters[5] = first_arg;\n" +
                                    "\tregisters[6] = second_arg;\n";
                break;
            case 3:
                header = "int generated(int first_arg, int second_arg, int third_arg)";
                inputAssignment = "\tregisters[5] = first_arg;\n" +
                        "\tregisters[6] = second_arg;\n" +
                        "\tregisters[7] = third_arg;\n";
                break;
            case 4:
                header = "int generated(int first_arg, int second_arg, int third_arg, int fourth_arg)";
                inputAssignment = "\tregisters[5] = first_arg;\n" +
                        "\tregisters[6] = second_arg;\n" +
                        "\tregisters[7] = third_arg;\n" +
                        "\tregisters[8] = fourth_arg;\n";
                break;
            case 5:
                header = "int generated(int first_arg, int second_arg, int third_arg, int fourth_arg, int fifth_arg)";
                inputAssignment = "\tregisters[5] = first_arg;\n" +
                        "\tregisters[6] = second_arg;\n" +
                        "\tregisters[7] = third_arg;\n" +
                        "\tregisters[8] = fourth_arg;\n" +
                        "\tregisters[9] = fifth_arg;\n";
                break;
            default:
                System.err.println("To generate code provide the function input number\n" +
                        "Supported range: [0-5]");
                System.exit(-1);
        }

        try {
            createHeaderFile(header);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "#include \"generated.h\"\n#include \"uthash.h\"\n#include <stdio.h> \n\n"+
                "struct memAddress {\n" +
                "    int address;                    /* key */\n" +
                "    int value;\n" +
                "    UT_hash_handle hh;         /* makes this structure hashable */\n" +
                "};\n\n" +
                "struct memAddress *memory = NULL;\n\n"+
                "int load(int address) {\n" +
                "    struct memAddress *s;\n" +
                "\n" +
                "    HASH_FIND_INT(memory, &address, s);\n" +
                "    if (s==NULL){\n" +
                "        fprintf( stderr, \"Attempted access to unused memory address at: %d\\n\", address);\n" +
                "        return 0;\n" +
                "    }\n" +
                "    printf(\"Loaded value : %d from address: %d\\n\", s->value, address);\n"+
                "    return s->value;" +
                "}\n\n"+
                "void store(int address, int value) {\n" +
                "    struct memAddress *s;\n" +
                "\n" +
                "    printf(\"Stored value : %d at address: %d\\n\", value, address);\n" +
                "    HASH_FIND_INT(memory, &address, s);\n" +
                "    if (s==NULL) {\n" +
                "            s = (struct memAddress *)malloc(sizeof *s);\n" +
                "            s->address = address;\n" +
                "            s->value = value;\n" +
                "            HASH_ADD_INT( memory, address, s );\n" +
                "    }else{\n" +
                "            struct memAddress *newS;\n" +
                "            newS = (struct memAddress *)malloc(sizeof *newS);\n" +
                "            newS->address = address;\n" +
                "            newS->value = value;\n" +
                "            HASH_REPLACE_INT( memory, address, newS, s);\n" +
                "    }\n" +
                "    return;\n" +
                "}\n\n"+
                "void storeInSimulatedMemory(int *array, int size){\n" +
                "    for (int i = 0; i < size; i++){\n" +
                "        store((int)array + 2*i, array[i]);\n" +
                "    }\n" +
                "}" +
                header +"{\n" +
                "\tint flags[8];\n" +
                "\tint PC = 0;\n" +
                "\tint imm = 0;\n" +
                "\tint registers[32];\n" +
                "\tregisters[0] = 0;\n"+ inputAssignment;
    }


    private void createHeaderFile(String header) throws IOException {
        String text = "#ifndef GENERATED_H_   /* Include guard */\n" +
                "#define GENERATED_H_\n" +
                "\n" +
                "int load(int address);  /* load memory from address */\n" +
                "\n" +
                "void store(int address, int value);  /* store value at address */\n" +
                "\n" +
                "void storeInSimulatedMemory(int *array, int size);\n" +
                "\n" +
                header + ";\n" +
                "\n" +
                "#endif // GENERATED_H_";
        FileOutputStream out = new FileOutputStream("output/generated.h");
        out.write(text.getBytes());
        out.close();

    }
}

/*
LOAD
int load(int address) {
    struct memAddress *s;

    HASH_FIND_INT( memory, &address, s );
    return s;
}
STORE
void store(int address, int value) {
    struct memAddress *s;

    HASH_FIND_INT(memory, &address, s);
    if (s==NULL) {
            s = (struct memory *)malloc(sizeof *s);
            s->address = address;
            s->value = value;
            HASH_ADD_INT( memory, address, s );
    }else{
            struct memAddress *newS;
            newS->address = address;
            newS->value = value;
            HASH_REPLACE_INT( memory, address, newS, s);
    }
    return;
}
void storeInSimulatedMemory(void *array, int size){
    for (int i = 0; i < size; i++){
        store((int)array + 2*i, array[i]);
    }
}

*/
