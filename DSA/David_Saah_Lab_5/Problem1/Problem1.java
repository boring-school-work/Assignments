/**
 * Problem1
 */
public class Problem1 {

    public static void main(String[] args) {
        HashTable table = new HashTable();

        try {
            System.out.printf("Initial size: %d\n", table.getSize());
            System.out.printf("Initial capacity: %d\n", table.getCapacity());

            System.out.println();
            System.out.println("Adding entries...");
            table.insert("Kojo", 1.0);
            table.insert("Kofi", 2.0);
            table.insert("Kwame", 3.0);
            table.insert("Kwesi", 4.0);
            table.insert("Kwabena", 6.0);
            table.insert("Kwaku", 7.0);
            table.insert("Yaw", 8.0);
            table.insert("Esi", 9.0);
            table.insert("Akosua", 10.0);
            table.insert("Adwoa", 11.0);

            System.out.println();
            System.out.printf("Size: %d\n", table.getSize());
            System.out.printf("Capacity: %d\n", table.getCapacity());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}