public class Some {
  public static void main(String[] args) {
    System.out.println("Testing 2D Array with fixed size");
    String[][] a = new String[3][2];
    System.out.println(a.length);
    System.out.println(a[0].length);
    System.out.println(a[0][0]);

    System.out.println();

    System.out.println("Testing 2D array with variable size");
    int[][] b = new int[3][];
    System.out.println(b.length);
    // b[0][0] = 2;
    // System.out.println(b[0][0]);
    b[0] = new int[3];
    b[1] = new int[2];
    b[2] = new int[4];
    System.out.println(b[0].length);
    System.out.println(b[1].length);
    System.out.println(b[2].length);
  }
}
