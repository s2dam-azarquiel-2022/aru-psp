#include <stdio.h>
#include <unistd.h>
#include <sys/file.h>

#define COUNT "count"
#define COUNT_LOCK "count.lock"

int writeValue(int count) {
	FILE *file = fopen(COUNT, "w");
	fprintf(file, "%d", count);
	fclose(file);
}

int readValue() {
	FILE *file = fopen(COUNT, "r");
	int count;
	if (file == NULL || fscanf(file, "%d", &count) == 0) {
		count = 0;
		writeValue(count);
	}
	fclose(file);
	return count;
}

int lockFile() {
	int lockfile;
	while (1) {
		lockfile = open(COUNT_LOCK, O_CREAT, 0444);
		if (flock(lockfile, LOCK_EX)) { close(lockfile); }
	       	else { break; }
	}
	return lockfile;
}

void unlockFile(int lockfile) {
	unlink(COUNT_LOCK);
	flock(lockfile, LOCK_UN);
	close(lockfile);
}

