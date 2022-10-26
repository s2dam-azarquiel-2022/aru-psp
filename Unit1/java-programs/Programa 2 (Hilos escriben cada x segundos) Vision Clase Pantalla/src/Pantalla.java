
public class Pantalla {
  private int linea;
  public Pantalla() {
    linea=1;
  }
  public synchronized void Escribe(String texto){
    System.out.printf("Linea %2d - %s \n",linea,texto);
    linea++;
  }
}
