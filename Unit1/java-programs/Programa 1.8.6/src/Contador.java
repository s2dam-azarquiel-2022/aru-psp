 
public class Contador {
 	public synchronized int inc(){
		int contador; 
		contador=Fichero.leovalor();  
		contador++;
		Fichero.escribovalor(contador);
		return contador;
	}
	public synchronized int dec() {
		int contador; 
		contador=Fichero.leovalor(); 
		try {
		  Thread.sleep(500);
		} catch (InterruptedException e) {}
		contador--;
		Fichero.escribovalor(contador);
		return contador;
	}
	public synchronized int valor(){
		return Fichero.leovalor();  
	}
}
