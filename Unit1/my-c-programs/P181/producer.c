#include <stdio.h>
#include "countFileHandler.h"

int main(int argc, char *argv[]) {
	int count = readValue();
	printf("Producer: read -> %d\n", count);
	sleep(5);
	count++;
	writeValue(count);
	printf("Producer: write -> %d\n", count);
}

