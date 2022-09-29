public class Productor_consumidor {
	public static void main(String[] args) {
		System.out.println(" Empieza el hilo principal valor del contador "+ Fichero.leovalor());
		Consumidor c=new Consumidor("consumidor1");
		Productor p=new Productor("productor1");
	}

}
