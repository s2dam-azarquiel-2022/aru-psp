#include <stdio.h>
#include "fichero.h"
#include <sys/types.h>

int main(int argc,char **argv){
  int contador;
  int pid=fork();
  if (pid==0){
    // Soy el hijo (Productor)
    int contador=leovalor();
    printf(" Productor: Lectura=%d \n",contador);
    sleep(5);
    contador++;
    escribovalor(contador);
    printf(" Productor: Escritura=%d \n",contador);
    // Para que no termine y pueda ver el proceso
    sleep(10);
  }
  else {
    pid=fork();
    if (pid==0){
      // Soy el hijo consumidor
      sleep(1);
      int contador=leovalor();
      printf(" Consumidor: Lectura=%d \n",contador);
      contador--;
      escribovalor(contador);
      printf(" Consumidor: Escritura=%d \n",contador);
      // Para que no termine y pueda ver el proceso
      sleep(10);
    }
    else {
      // El padre tambien se queda un rato esperando 
      sleep(10);
    }
  }
}

