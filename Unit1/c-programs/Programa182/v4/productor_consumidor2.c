#include <sys/types.h>

int main(int argc,char **argv){
  int pid=fork();
  if (pid==0){
    // Soy el hijo (Productor)
    execv("./productor",argv);
    // Para que no termine y pueda ver el proceso
    sleep(10);
  }
  else {
    pid=fork();
    if (pid==0){
      // Soy el hijo consumidor
      sleep(1);
      execv("./consumidor",argv);
      // Para que no termine y pueda ver el proceso
      sleep(10);
    }
    else {
      // El padre tambien se queda un rato esperando para verlo
      sleep(10);
    }
  }
}

