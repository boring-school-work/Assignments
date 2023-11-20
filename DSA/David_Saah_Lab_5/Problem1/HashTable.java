/**
 * HashTable implementation using an array.
 * 
 * @author David Saah
 * @version 1.0
 * @since 2023-11-20
 */
public class HashTable {
    private Entry[] table; // the array of entries
    private int capacity = 11; // default size of the array
    private int size = 0; // number of entries in the array
    private int factor = 7; // used in secondary hash function

    /**
     * HashTable constructor
     */
    public HashTable() {
        table = new Entry[capacity];
    }

    /**
     * Primary hash function to determine initial index of the array
     * 
     * @param key the key to be hashed
     * 
     * @return the index of the array
     */
    public int p_hash(String key) {
        return key.hashCode() % capacity;
    }

    /**
     * Secondary hash function to determine the step size
     * 
     * @param key the key to be hashed
     * 
     * @return the step size
     */
    public int s_hash(String key) {
        return factor - (key.hashCode() % factor);
    }

    /**
     * Inserts a new entry into the hash table
     * 
     * @param key   the key of the entry
     * @param value the value of the entry
     * 
     * @throws Exception if key collision occurs after double hashing
     */
    public void insert(String key, double value) throws Exception {
        // resize table if it is full
        if (size == capacity) {
            resize();
        }

        int new_index = -1; // tracks the index of the new entry
        int p_index = p_hash(key); // primary hash index
        int s_index = s_hash(key); // secondary hash index
        int i = 0; // tracks iterations

        while (i < capacity) {
            int index = (p_index + i * s_index) % capacity; // double hashing to get new index

            if (table[index] == null) {
                // if the entry is empty, update new_index
                new_index = index;
                break;
            } else if (table[index].getStudentID().equals(key)) {
                // if entry exists, update the value
                table[index].setGrade(value);
                System.out.printf("Entry %s updated\n", key);
                return;
            }

            i++; // increment iterations
        }

        // if new_index is still -1, then the table is full
        // else insert the new entry
        if (new_index != -1) {
            table[new_index] = new Entry(key, value);
            size++;
            System.out.printf("Entry %s added\n", key);
        } else {
            // this occurs if there is a key collision after double hashing
            throw new Exception("Entry " + key + " not added");
        }
    }

    /**
     * Searches for the value of the entry with the given keyreturn
     * 
     * @param key the key of the entry
     * 
     * @return the value of the entry
     * @throws Exception if the entry is not found
     */
    public double search(String key) throws Exception {
        int p_index = p_hash(key);
        int s_index = s_hash(key);
        int i = 0;

        while (i < capacity) {
            int index = (p_index + i * s_index) % capacity;

            if (table[index] == null) {
                throw new Exception("Entry " + key + " not found");
            } else if (table[index].getStudentID().equals(key)) {
                return table[index].getGrade();
            }

            i++;
        }

        throw new Exception("Entry " + key + " not found");
    }

    /**
     * Deletes the entry with the given key
     *
     * @param key the key of the entry
     * 
     * @throws Exception if the entry is not found
     */
    public void delete(String key) throws Exception {
        int p_index = p_hash(key);
        int s_index = s_hash(key);
        int i = 0;

        while (i < capacity) {
            int index = (p_index + i * s_index) % capacity;

            if (table[index] != null && table[index].getStudentID().equals(key)) {
                table[index] = null;
                size--;
                System.out.println("Entry " + key + " deleted");
            }

            i++;
        }

        throw new Exception("Entry " + key + " not found");
    }

    /**
     * Display entries in the hash table
     */
    public void display() {
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                System.out.println(table[i].getStudentID() + " " + table[i].getGrade());
            }
        }
    }

    /**
     * Get a new prime number for hash table operations
     * 
     * @param n   the current value
     * @param mul the factor to multiply the capacity by
     * 
     * @return a new prime number
     */
    public int getPrime(int n, int mul) {
        int new_n = n * mul + 1; // increase current value by specified multiplier

        for (int i = n; n < Math.sqrt(new_n); i++) {
            if (new_n % i == 0) {
                new_n += 2;
                i = 1;
            }
        }

        return new_n;
    }

    /**
     * Resize table capacity and rehash entries
     * 
     * @throws Exception if collision occurs after resizing
     */
    public void resize() throws Exception {
        capacity = getPrime(capacity, 2);
        Entry[] old_table = table;
        table = new Entry[capacity];
        size = 0;
        factor = getPrime(factor, 2);

        // repopulate table with old entries using new hashes
        for (int i = 0; i < old_table.length; i++) {
            if (old_table[i] != null) {
                insert(old_table[i].getStudentID(), old_table[i].getGrade());
            }
        }
    }

    /**
     * Gets the number of entries in the hash table
     * 
     * @return the number of entries
     */
    public int getSize() {
        return size;
    }

    /**
     * Gets the capacity of the hash table
     * 
     * @return the capacity of the hash table
     */
    public int getCapacity() {
        return capacity;
    }
}