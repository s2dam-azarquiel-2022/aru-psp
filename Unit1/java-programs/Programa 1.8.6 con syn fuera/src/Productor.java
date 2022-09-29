
public class Productor extends Thread{
	private Contador cont;
	public Productor(Contador pc,String Nombre) {
		if (Nombre!=null) setName(Nombre);
		cont=pc;
		start();
	}
	public void run(){
		for (int i=1; i<=3;i++){
			// Espero a la recepción del evento
			synchronized (cont){
			  System.out.println(" PRODUCTOR: Evento " + i + " contador queda en "+ cont.inc());
			}
		}
	
	}
}

