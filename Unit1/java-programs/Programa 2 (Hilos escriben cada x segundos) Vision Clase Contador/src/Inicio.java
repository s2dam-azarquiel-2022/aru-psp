
public class Inicio {
  public static void main(String[] args) {
	Contador cont = new Contador();
    for (int i = 1; i <= 5; i++)
      new Hilo("hilo", i, cont);
  }
}
