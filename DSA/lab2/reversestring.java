package DSA.lab2;

import java.util.Scanner;

public class reversestring {
  public static void main(String[] args) {
    Scanner getInput = new Scanner(System.in);
    // String[] data;
    StringBuilder sb = new StringBuilder();

    System.out.println("Enter some lines of text. Press enter twice when done.");
    sb.append(getInput.nextLine() + ',');
    System.out.println(sb);

    getInput.close();
  }
}
