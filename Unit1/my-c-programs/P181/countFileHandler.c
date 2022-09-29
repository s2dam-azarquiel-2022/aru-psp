#include <stdio.h>

#define CONTADOR "count"

int readValue() {
	FILE *file = fopen(CONTADOR, "r");
	int count;
	fscanf(file, "%d", &count);
	fclose(file);
	return count;
}

int writeValue(int count) {
	FILE *file = fopen(CONTADOR, "w");
	fprintf(file, "%d", count);
	fclose(file);
}

