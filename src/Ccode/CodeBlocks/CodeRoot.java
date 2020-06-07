package Ccode.CodeBlocks;

import Ccode.CodeBlock;

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
                header = "int generated(int *memory)";
                break;
            case 1:
                header = "int generated(int *first_arg)";
                inputAssignment = "\tregisters[5] = first_arg;\n";
                break;
            case 2:
                header = "int generated(int *first_arg, int *second_arg)";
                inputAssignment = "\tregisters[5] = first_arg;\n" +
                                    "\tregisters[6] = second_arg;\n";
                break;
            case 3:
                header = "int generated(int *first_arg, int *second_arg, int *third_arg)";
                inputAssignment = "\tregisters[5] = first_arg;\n" +
                        "\tregisters[6] = second_arg;\n" +
                        "\tregisters[7] = third_arg;\n";
                break;
            case 4:
                header = "int generated(int *first_arg, int *second_arg, int *third_arg, int *fourth_arg)";
                inputAssignment = "\tregisters[5] = first_arg;\n" +
                        "\tregisters[6] = second_arg;\n" +
                        "\tregisters[7] = third_arg;\n" +
                        "\tregisters[8] = fourth_arg;\n";
                break;
            case 5:
                header = "int generated(int *first_arg, int *second_arg, int *third_arg, int *fourth_arg, int *fifth_arg)";
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
        return "#include \"generated.h\"\n#include \"uthash.h\"\n\n"+
                "struct memAddress {\n" +
                "    int address;                    /* key */\n" +
                "    int value;\n" +
                "    UT_hash_handle hh;         /* makes this structure hashable */\n" +
                "};" +
                "struct memAddress *memory = NULL;\n"+
                header +"{\n" +
                "\tint flags[8];\n" +
                "\tint PC = 0;\n" +
                "\tint imm = 0;\n" +
                "\tint registers[32];\n" +
                "\tregisters[0] = 0;\n"+ inputAssignment;
    }
}

/*
LOAD
void load(int address) {
    struct memAddress *s;

    HASH_FIND_INT( memory, &address, s );
    return s;
}
STORE
int store(int user_id, char *name) {
    struct my_struct *s;

    HASH_FIND_INT(users, &user_id, s);
    if (s==NULL) {
            s = (struct my_struct *)malloc(sizeof *s);
            s->id = user_id;
            HASH_ADD_INT( users, id, s );
    }
    return ;
}
*/
