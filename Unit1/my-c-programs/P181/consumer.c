#include <stdio.h>
#include "countFileHandler.h"

int main(int argc, char *argv[]) {
	int count = readValue();
	printf("Consumer: read -> %d\n", count);
	sleep(2);
	count--;
	writeValue(count);
	printf("Consumer: write -> %d\n", count);
}

