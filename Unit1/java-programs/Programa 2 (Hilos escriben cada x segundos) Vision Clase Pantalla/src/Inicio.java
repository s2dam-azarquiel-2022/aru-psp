
public class Inicio {
  public static void main(String[] args) {
	Pantalla pant=new Pantalla();
    for (int i=1;i<=5;i++)
      new Hilo("hilo",i,pant);
  }
}
