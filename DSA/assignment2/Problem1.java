import java.util.ArrayList;

/**
 * Building a Generic Inventory System
 *
 * @author David Saah
 * @since 2023-09-13
 * @version 1.0
 */
public class Problem1 {
  public static void main(String[] args) {
    // create products
    ElectronicProduct iron = new ElectronicProduct("Iron", 20, 5);
    ClothingProduct jersey = new ClothingProduct("Jersey", 40.0, 8);
    BookProduct go = new BookProduct("Go Book", 100, 4);
    CeramicProduct bowl = new CeramicProduct("Bowl", 20, 6);
    WoodenProduct table = new WoodenProduct("Table", 10, 7);

    // create store inventory
    StoreInventory<Product> accraMall = new StoreInventory<Product>();

    /* Test 1 -> Add products to the inventory */
    accraMall.addProduct(iron);
    accraMall.addProduct(jersey);
    accraMall.addProduct(go);
    accraMall.addProduct(bowl);
    accraMall.addProduct(table);

    System.out.printf("Initial list of products in the inventory: \n\n");

    /* Test 2 -> List all products */
    accraMall.listAllProducts();

    System.out.println();

    /* Test 3 -> Get total value of products in the inventory */
    System.out.printf("The total value of the products in the inventory is %.2f.\n", accraMall.getTotalValue());

    System.out.println();

    try {
      /* Test 4 -> Remove a product */
      System.out.println("Removing a bowl...");
      accraMall.removeProduct("bowl");
      System.out.println("Inventory after removing the bowl:");
      System.out.println();
      accraMall.listAllProducts();
      System.out.println();

      /* Test 5 -> Update product quantity */
      System.out.println("Updating the quantity of iron...");
      accraMall.updateProductQuantity("iron", 8);
      System.out.println("Inventory after update:");
      System.out.println();
      accraMall.listAllProducts();
      System.out.println();

      /* Test 6 -> Update product price */
      System.out.println("Updating the price of iron...");
      accraMall.updateProductPrice("iron", 80);
      System.out.println("Inventory after update:");
      System.out.println();
      accraMall.listAllProducts();
      System.out.println();

      /* Test 7 -> find a random product */
      Product randomProduct = accraMall.findProduct("go book");
      System.out.printf("The product found is %s.\n", randomProduct.getName());
      System.out.println();

      /* Test 8 -> find the most expensive product */
      Product mostExpensive = accraMall.findMostExpensiveProduct();
      System.out.printf("The most expensive product is %s, and it costs %.2f.\n",
          mostExpensive.getName(), mostExpensive.getPrice());
      System.out.println();
    } catch (Exception e) {
      // catch any errors
      System.out.println(e.getMessage());
      System.exit(1);
    }
  }

}

/**
 * Product class
 *
 * A generic class that can store information about a product
 */
abstract class Product {
  protected String name; // The name of the product
  protected double price; // The price of the product
  protected int quantity; // The quantity of the product

  public Product(String name, double price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  /**
   * Set the price of the product
   *
   * @param price The price of the product
   */
  void setPrice(double price) {
    this.price = price;
  }

  /**
   * Set the quantity of the product
   *
   * @param quantity The quantity of the product
   */
  void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /**
   * Get the name of the product
   *
   * @return The name of the product
   */
  String getName() {
    return name;
  }

  /**
   * Get the price of the product
   *
   * @return The price of the product
   */
  double getPrice() {
    return price;
  }

  /**
   * Get the quantity of the product
   *
   * @return The quantity of the product
   */
  int getQuantity() {
    return quantity;
  }
}

/**
 * Create an electronic product
 */
class ElectronicProduct extends Product {
  ElectronicProduct(String name, double price, int quantity) {
    super(name, price, quantity);
  }
}

/**
 * Create a clothing product
 */
class ClothingProduct extends Product {
  ClothingProduct(String name, double price, int quantity) {
    super(name, price, quantity);
  }
}

/**
 * Create a book product
 */
class BookProduct extends Product {
  BookProduct(String name, double price, int quantity) {
    super(name, price, quantity);
  }
}

/**
 * Create a ceramic product
 */
class CeramicProduct extends Product {
  CeramicProduct(String name, double price, int quantity) {
    super(name, price, quantity);
  }
}

/**
 * Create a wooden product
 */
class WoodenProduct extends Product {
  WoodenProduct(String name, double price, int quantity) {
    super(name, price, quantity);
  }
}

/**
 * StoreInventory class
 *
 * A generic class that store products in an inventory
 *
 * @param T The type of product to store
 */
class StoreInventory<T extends Product> {
  private ArrayList<T> products;

  /**
   * Create an empty inventory
   */
  StoreInventory() {
    products = new ArrayList<T>();
  }

  /**
   * Add a product to the inventory
   *
   * @param product The product to add
   */
  void addProduct(T product) {
    products.add(product);
  }

  /**
   * Find a product in the inventory
   *
   * @param name The name of the product to find
   * @return The product found
   * @throws Exception If the product is not found
   */
  T findProduct(String name) throws Exception {
    for (T p : products) {
      if (p.getName().equalsIgnoreCase(name)) {
        return p;
      }
    }

    throw new Exception("ERROR: Item not found in the inventory");
  }

  /**
   * Remove a product from the inventory
   *
   * @param name The name of the product to remove
   * @throws Exception If the product is not found
   */
  void removeProduct(String name) throws Exception {
    products.remove(findProduct(name));
  }

  /**
   * Display all the products in the inventory
   */
  void listAllProducts() {
    System.out.println("OUTPUT FORMAT: Name, Unit Price, Quantity");
    System.out.println("-".repeat(50));

    for (T p : products) {
      System.out.printf("%s, %.2f, %d \n", p.getName(), p.getPrice(), p.getQuantity());
    }
  }

  /**
   * Get the total value of all the products in the inventory
   *
   * @return The total value of all the products in the inventory
   */
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

  /**
   * Update the quantity of a product in the inventory
   *
   * @param name     The name of the product to update
   * @param quantity The new quantity of the product
   * @throws Exception If the product is not found
   */
  void updateProductQuantity(String name, int quantity) throws Exception {
    T p = findProduct(name);
    p.setQuantity(quantity);
  }

  /**
   * Update the price of a product in the inventory
   *
   * @param name  The name of the product to update
   * @param price The new price of the product
   * @throws Exception If the product is not found
   */
  void updateProductPrice(String name, double price) throws Exception {
    T p = findProduct(name);
    p.setPrice(price);
  }

  /**
   * Find the most expensive product in the inventory
   *
   * @return The most expensive product in the inventory
   */
  T findMostExpensiveProduct() {
    if (products.isEmpty()) {
      return null;
    }

    T mostExpensive = products.get(0);

    for (T p : products) {
      if (p.getPrice() > mostExpensive.getPrice()) {
        mostExpensive = p;
      }
    }

    return mostExpensive;
  }

}
