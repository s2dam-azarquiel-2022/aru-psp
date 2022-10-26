
public class Contador {
  private int val;

  public Contador() {
    this.val = 1;
  }

  public int getVal() {
    return val++;
  }
}
