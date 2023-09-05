package DSA.lab2;

public class stringbuildertest {
  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    sb.append("hello");
    System.out.println(sb);

    StringBuilder sb1 = new StringBuilder("Something");
    sb1.setCharAt(4, ' ');
    System.out.println(sb1);
  }
}
