import java.util.ArrayList;

abstract class Product {
  protected String name;
  protected double price;
  protected int quantity;

  public Product(String name, double price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  void setPrice(double price) {
    this.price = price;
  }

  void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  String getName() {
    return name;
  }

  double getPrice() {
    return price;
  }

  int getQuantity() {
    return quantity;
  }
}

class ElectronicProduct extends Product {

  ElectronicProduct(String name, double price, int quantity) {
    super(name, price, quantity);
  }
}

class ClothingProduct extends Product {

  ClothingProduct(String name, double price, int quantity) {
    super(name, price, quantity);
  }
}

class BookProduct extends Product {

  BookProduct(String name, double price, int quantity) {
    super(name, price, quantity);
  }
}

class CeramicProduct extends Product {

  CeramicProduct(String name, double price, int quantity) {
    super(name, price, quantity);
  }
}

class WoodenProduct extends Product {

  WoodenProduct(String name, double price, int quantity) {
    super(name, price, quantity);
  }
}

class StoreInventory<T extends Product> {
  ArrayList<T> products = new ArrayList<>();

  void addProduct(T product) {
    products.add(product);
  }

  T findProduct(String name) throws Exception {
    for (T p : products) {
      if (p.getName().equalsIgnoreCase(name)) {
        return p;
      }
    }

    throw new Exception("ERROR: Item not found in the inventory");
  }

  void removeProduct(String name) throws Exception {
    products.remove(findProduct(name));
  }

  void listAllProducts() {
    System.out.println("OUTPUT FORMAT: Name, Unit Price, Quantity");
    System.out.println("-".repeat(50));

    for (T p : products) {
      System.out.printf("%s, %.2f, %d \n", p.getName(), p.getPrice(), p.getQuantity());
    }
  }

  double getTotalValue() {
    if (products.isEmpty()) {
      return 0;
    }

    double total = 0;

    for (T p : products) {
      total += p.getQuantity() * p.getPrice();
    }

    return total;
  }

  void updateProductQuantity(String name, int quantity) throws Exception {
    T p = findProduct(name);
    p.setQuantity(quantity);
  }

  void updateProductPrice(String name, double price) throws Exception {
    T p = findProduct(name);
    p.setPrice(price);
  }

}

/**
 * Problem1
 */
public class Problem1 {

  public static void main(String[] args) {
    ElectronicProduct iron = new ElectronicProduct("Iron", 20, 5);
    ClothingProduct jersey = new ClothingProduct("Jersey", 40.0, 8);
    BookProduct go = new BookProduct("Go Book", 100, 4);
    CeramicProduct bowl = new CeramicProduct("Bowl", 20, 6);
    WoodenProduct table = new WoodenProduct("Table", 10, 7);

    StoreInventory<Product> accraMall = new StoreInventory<Product>();

    accraMall.addProduct(iron);
    accraMall.addProduct(jersey);
    accraMall.addProduct(go);
    accraMall.addProduct(bowl);
    accraMall.addProduct(table);

    accraMall.listAllProducts();

    try {
      accraMall.updateProductQuantity("iron", 8);
      accraMall.updateProductPrice("iron", 80);
      accraMall.removeProduct("bowl");
      accraMall.findProduct("go book");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.exit(1);
    }

    System.out.println();
    accraMall.listAllProducts();

    //
    // try {
    // oneIron = accraMall.findProduct("iron");
    // } catch (Exception e) {
    // System.out.println(e.getMessage());
    // System.exit(1);
    // }
    //
    // System.out.println(oneIron.name);

    System.out.println(accraMall.getTotalValue());
  }
}
