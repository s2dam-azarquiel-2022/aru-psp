
public class Consumidor extends Thread{
	private Contador cont;
	public Consumidor(Contador pc,String Nombre) {
		if (Nombre!=null) setName(Nombre);
		cont=pc;
		start();
	}
	public void run(){
		for (int i=1; i<=3;i++){
			// Espero a la recepci�n del evento
			System.out.println(" CONSUMIDOR: Evento " + i + " contador queda en "+ cont.dec());		
		}
	
	}
}

