
public class Consumidor extends Thread{
  public Consumidor(String Nombre) {
    if (Nombre!=null) setName(Nombre);
	start();
  }
  public void run(){
    int contador;
	contador=Fichero.leovalor();
	System.out.printf(" Consumidor: Lectura=%d \n",contador);
	contador--;
	Fichero.escribovalor(contador);
	System.out.printf(" Consumidor: Escritura=%d \n",contador);
  }
}


