#ifndef GENERATED_H_   /* Include guard */
#define GENERATED_H_

int load(int address);  /* load memory from address */

void store(int address, int value);  /* store value at address */

void storeInSimulatedMemory(int *array, int size);

int generated(int first_arg, int second_arg, int third_arg, int fourth_arg, int fifth_arg);

#endif // GENERATED_H_