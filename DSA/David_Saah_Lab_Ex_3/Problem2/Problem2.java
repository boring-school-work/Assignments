/**
 * Testing Cache implementation
 *
 * @author David Saah
 * @since 09-10-2023
 * @version 1.0
 */
public class Problem2 {

  public static void main(String[] args) {
    /* Create an integer cache */
    Cache<Integer> numsCache = new Cache<Integer>(3);

    /* Add integers to cache */
    for (int i = 0; i < 6; i += 2) {
      numsCache.AddItem(i);
    }

    System.out.println("Cache size: " + numsCache.getSize());
    System.out.println();

    /* Display cache list */
    numsCache.display();

    /* Get item from cache */
    System.out.printf("Getting %d from cache...\nResponse: %d\n", 2,
        numsCache.GetItem(2));
    System.out.println();

    /* Display cache list */
    numsCache.display();
  }
}
