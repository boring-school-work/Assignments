package DSA.practice.generics;

public class GenDemo {
  public static void main(String[] args) {
    Table<String, Integer> table1 = new Table("Food", 23);
    Table<Integer, Integer> table2 = new Table(112, 23);

    System.out.printf("Table1 types: ");
  }
}

class Table<X, Y> {
  X key;
  Y value;

  Table(X key, Y value) {
    this.key = key;
    this.value = value;
  }

  X getKey() {
    return key;
  }

  Y getValue() {
    return value;
  }

  String getKeyType() {
    return getKey().getClass().getName();
  }

  String getValueType() {
    return getValue().getClass().getName();
  }
}
