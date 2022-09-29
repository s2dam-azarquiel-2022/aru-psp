#include <unistd.h>
#include "consumer.h"
#include "producer.h"

int main(int argc, char *argv[]) {
	if (fork() == 0) { producerAction(); }
	else if (fork() == 0) { consumerAction(); }
	else { sleep(2); } 
}

