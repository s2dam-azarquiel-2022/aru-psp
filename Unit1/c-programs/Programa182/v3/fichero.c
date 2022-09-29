#include <stdio.h>
#define FICHERO "contador.txt"

int leovalor(){
  FILE *fp;
  int contador;
  fp=fopen(FICHERO,"r");
  fscanf(fp,"%d",&contador);
  fclose(fp);
  return contador;
}
void escribovalor(int contador){
  FILE *fp;
  fp=fopen(FICHERO,"w");
  fprintf(fp,"%d",contador);
  fclose(fp);
}

