 
public class Contador{
 	public int inc(){
		int contador; 
		contador=Fichero.leovalor();  
		contador++;
		Fichero.escribovalor(contador);
		return contador;
	}
	public int dec() {
		int contador; 
		contador=Fichero.leovalor(); 
		try {
		  Thread.sleep(500);
		} catch (InterruptedException e) {}
		contador--;
		Fichero.escribovalor(contador);
		return contador;
	}
	public int valor(){
		return Fichero.leovalor();  
	}
}
