package DSA.lab3;

import java.util.ArrayList;

public class GenMethodTestMain {
  public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
    ArrayList<E> newlist = new ArrayList<>();

    for (E l : list) {
      if (!newlist.contains(l)) {
        newlist.add(l);
      }
    }

    return newlist;
  }

  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("a");
    list.add("a");
    list.add("b");
    list.add("c");
    list.add("c");
    list.add("e");
    list.add("s");
    list.add("a");

    System.out.println("Array with duplicates: " + list);
    System.out.println("Array without duplicates: " + removeDuplicates(list));
  }
}
