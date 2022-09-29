public class Productor_consumidor{
	public static void main(String[] args)  throws InterruptedException {
		Contador cont=new Contador();
		System.out.println(" Empieza el hilo principal con valor de contador="+cont.valor());
		Consumidor c=new Consumidor(cont,"Consumidor");
		Productor p=new Productor(cont,"Productor");
		c.join();
		p.join();
		System.out.println(" Terminan todos los hilos con un valor de contador="+cont.valor());
	}

}
