#include <stdio.h>
#include "fichero.h"

int main(int argc,char **argv){
  int contador;
  contador=leovalor();
  printf(" Consumidor: Lectura=%d \n",contador);
  contador--;
  escribovalor(contador);
  printf(" Consumidor: Escritura=%d \n",contador);
}

