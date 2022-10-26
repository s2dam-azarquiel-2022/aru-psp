
public class Hilo extends Thread{
  String nombre;
  int numero;
  Pantalla pant;
  int vez;
  public Hilo(String pnombre,int pnumero,Pantalla ppant) {
	nombre=pnombre;
	numero=pnumero;
	pant=ppant;
	vez=1;
	setName(nombre+numero);
    start();
  }
  @Override
  public void run(){
    while (true){
      try {sleep(1000*numero);} catch (InterruptedException e) {}
      pant.Escribe(getName()+" vez "+vez++);
    }
  }
}
