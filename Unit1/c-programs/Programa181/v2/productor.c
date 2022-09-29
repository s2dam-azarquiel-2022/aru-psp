#include <stdio.h>
#include "fichero.h"

int main(int argc,char **argv){
  int contador;
  contador=leovalor();
  printf(" Productor: Lectura=%d \n",contador);
  sleep(5);
  contador++;
  escribovalor(contador);
  printf(" Productor: Escritura=%d \n",contador);
}

