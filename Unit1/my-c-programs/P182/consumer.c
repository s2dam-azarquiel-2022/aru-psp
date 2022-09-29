#include <stdio.h>
#include <unistd.h>
#include "countFileHandler.h"

void consumerAction() {
	int lockfile = lockFile();
	int count = readValue();
	printf("Consumer: read -> %d\n", count);
	count--;
	writeValue(count);
	printf("Consumer: write -> %d\n", count);
	unlockFile(lockfile);
}

