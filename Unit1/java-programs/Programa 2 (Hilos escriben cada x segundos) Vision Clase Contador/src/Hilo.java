
public class Hilo extends Thread {
  String nombre;
  int numero;
  Contador cont;
  int vez;

  public Hilo(String pnombre,int pnumero,Contador pcont) {
	nombre = pnombre;
	numero = pnumero;
	cont = pcont;
	vez = 1;
	setName(nombre + numero);
    start();
  }
  
  private String getText() {
	  return getName() + " vez " + vez++;
  }

  @Override
  public void run(){
    while (true){
      try { sleep(1000 * numero); } catch (InterruptedException e) {}
      synchronized(cont) {
        System.out.printf("Linea %2d - %s \n", cont.getVal(), getText());
      }
    }
  }
}
