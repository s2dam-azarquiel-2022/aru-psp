#include <stdio.h>
#include <unistd.h>
#include "countFileHandler.h"

void producerAction() {
	int lockfile = lockFile();
	int count = readValue();
	printf("Producer: read -> %d\n", count);
	count++;
	writeValue(count);
	printf("Producer: write -> %d\n", count);
	unlockFile(lockfile);
}

