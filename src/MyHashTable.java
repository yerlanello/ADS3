import java.util.Random;

class CustomHashTable<K, V> {

    static class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashNode<K, V>[] table;
    private int capacity = 11;
    private int size;

    public CustomHashTable() {
        this.table = new HashNode[capacity];
        this.size = 0;
    }

    private int hash(K key) {
        int hash = key.hashCode() % capacity;
        return hash < 0 ? hash + capacity : hash;
    }

    public void insert(K key, V value) {
        int index = hash(key);
        HashNode<K, V> newNode = new HashNode<>(key, value);
        if (table[index] == null) {
            table[index] = newNode;
        } else {
            HashNode<K, V> current = table[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public V retrieve(K key) {
        int index = hash(key);
        HashNode<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public V erase(K key) {
        int index = hash(key);
        HashNode<K, V> current = table[index];
        HashNode<K, V> prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    public boolean contains(K key) {
        int index = hash(key);
        HashNode<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public K getKey(V value) {
        for (int i = 0; i < capacity; i++) {
            HashNode<K, V> current = table[i];
            while (current != null) {
                if (current.value.equals(value)) {
                    return current.key;
                }
                current = current.next;
            }
        }
        return null;
    }

    public int[] getBucketSizes() {
        int[] bucketSizes = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            HashNode<K, V> current = table[i];
            int count = 0;
            while (current != null) {
                count++;
                current = current.next;
            }
            bucketSizes[i] = count;
        }
        return bucketSizes;
    }

    public static void main(String[] args) {
        CustomHashTable<Integer, Integer> hashTable = new CustomHashTable<>();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int key = random.nextInt(10000);
            int value = random.nextInt(10000);
            hashTable.insert(key, value);
        }
        int[] bucketSizes = hashTable.getBucketSizes();
        for (int i = 0; i < bucketSizes.length; i++) {
            System.out.println("Bucket " + i + ": " + bucketSizes[i] + " elements");
        }
    }
}