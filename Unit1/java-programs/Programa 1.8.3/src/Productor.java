
public class Productor extends Thread{
  public Productor(String Nombre) {
	if (Nombre!=null) setName(Nombre);
	start();
  }
  public void run(){
	int contador;
	contador=Fichero.leovalor();
	System.out.printf(" Productor: Lectura=%d \n",contador);
	try {sleep(500);
	} catch (InterruptedException e) {};
	contador++;
	Fichero.escribovalor(contador);
	System.out.printf(" Productor: Escritura=%d \n",contador);
  }
}
