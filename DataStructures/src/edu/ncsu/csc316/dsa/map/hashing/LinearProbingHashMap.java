package edu.ncsu.csc316.dsa.map.hashing;

import edu.ncsu.csc316.dsa.map.Map.Entry;

/**
 * The LinearProbingHashMap is implemented as a hash table that uses linear
 * probing for collision resolution.
 * 
 * The hash map uses a multiply-and-divide compression strategy for calculating
 * hash functions. The hash map ensures expected O(1) performance of
 * put, get, and remove
 * 
 * The hash table resizes if the load factor exceeds 0.5.
 * 
 * The LinearProbingHashMap class is based on the implementation developed for
 * use with the textbook:
 *
 * Data Structures and Algorithms in Java, Sixth Edition Michael T. Goodrich,
 * Roberto Tamassia, and Michael H. Goldwasser John Wiley and Sons, 2014
 * 
 * @author Dr. King
 * @author Tung Tran
 *
 * @param <K> the type of keys stored in the hash map
 * @param <V> the type of values associated with keys in the hash map
 */
public class LinearProbingHashMap<K, V> extends AbstractHashMap<K, V> {

	/** table entry of keys and values */
    private TableEntry<K, V>[] table;
    
    /** size of table entry */
    private int size;

    /**
     * Constructs a new linear probing hash map that uses natural ordering of keys
     * when performing comparisons. The created hash table uses the
     * {@link AbstractHashMap#DEFAULT_CAPACITY}
     */
    public LinearProbingHashMap() {
        this(AbstractHashMap.DEFAULT_CAPACITY, false);
    }

    /**
     * FOR TESTING PURPOSES ONLY! Constructs a new linear probing hash map that uses
     * natural ordering of keys when performing comparisons. The created hash table
     * uses the {@link AbstractHashMap#DEFAULT_CAPACITY}
     * 
     * @param isTesting if true, the hash table uses a predictable series of random
     *                  values for deterministic and repeatable testing
     */
    public LinearProbingHashMap(boolean isTesting) {
        this(AbstractHashMap.DEFAULT_CAPACITY, isTesting);
    }

    /**
     * Constructs a new linear probing hash map that uses natural ordering of keys
     * when performing comparisons. The created hash table is initialized to have
     * the provided capacity.
     * 
     * @param capacity the initial capacity of the hash table
     */
    public LinearProbingHashMap(int capacity) {
        this(capacity, false);
    }

    /**
     * FOR TESTING PURPOSES ONLY! Constructs a new linear probing hash map that uses
     * natural ordering of keys when performing comparisons. The created hash table
     * is initialized to have the provided capacity.
     * 
     * @param capacity  the initial capacity of the hash table
     * @param isTesting if true, the hash table uses a predictable series of random
     *                  values for deterministic and repeatable testing
     */
    public LinearProbingHashMap(int capacity, boolean isTesting) {
        super(capacity, isTesting);
        size = 0;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
    	EntryCollection collection = new EntryCollection();
        for (int i = 0; i < table.length; i++) {
        	if (!isAvailable(i)) {
        		collection.add(table[i]);
        	}
        }
        return collection;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void createTable(int capacity) {
        table = (TableEntry<K, V>[]) new TableEntry[capacity];
        size = 0;
    }

    private boolean isAvailable(int index) {
        return table[index] == null || table[index].isDeleted();
    }

    /**
	 * Citing Help from the Textbooks The code for this method is based on the
	 * bucketGet algorithm on page 427 in the course textbook "Data Structures and
	 * Algorithms" by Goodrich, Tamassia, Goldwasser.
	 */
    @Override
    public V bucketGet(int hash, K key) {
        int j = findBucket(hash, key);
        if (j < 0) {
        	return null;
        }
        return table[j].getValue();
    }

    /**
	 * Citing Help from the Textbooks The code for this method is based on the
	 * bucketPut algorithm on page 427 in the course textbook "Data Structures and
	 * Algorithms" by Goodrich, Tamassia, Goldwasser.
	 */
    @Override
    public V bucketPut(int hash, K key, V value) {
    	int j = findBucket(hash, key);
    	if (j >= 0) {
    		V temp = table[j].getValue();
    		table[j].setValue(value);
    		return temp;
    	}
    	table[-(j + 1)] = new TableEntry<>(key, value);
    	size++;
    	return null;
    }
    /**
	 * Citing Help from the Textbooks The code for this method is based on the
	 * findBucket algorithm on page 427 in the course textbook "Data Structures and
	 * Algorithms" by Goodrich, Tamassia, Goldwasser.
	 * 
	 * @param index is index of entry to be found
	 * @param key is key of entry to be found
	 * 
	 * @return integer representing if the bucket is found or nots
	 */
    private int findBucket(int index, K key) {
        int avail = -1;
        int j = index;
        do {
        	if (isAvailable(j)) {
        		if (avail == -1) {
        			avail = j;
        		}
        		if (table[j] == null) {
        			return -(avail + 1);
        		}
        	} else if (table[j].getKey().equals(key)) {
        		return j;
        	}
        	j = (j + 1) % table.length;
        } while (j != index);
        return -(avail + 1);
    }

    /**
	 * Citing Help from the Textbooks The code for this method is based on the
	 * bucketRemove algorithm on page 427 in the course textbook "Data Structures and
	 * Algorithms" by Goodrich, Tamassia, Goldwasser.
	 */
    @Override
    public V bucketRemove(int hash, K key) {
    	int j = findBucket(hash, key);
    	if (j < 0) {
    		return null;
    	}
    	V ans = table[j].getValue();
        // Remember to set the table bucket as DELETED using setDeleted(true)
    	table[j].setDeleted(true);
    	size--;
    	return ans;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    protected int capacity() {
        return table.length;
    }

    private static class TableEntry<K, V> extends MapEntry<K, V> {

    	/** determines if a table entry is deleted */
        private boolean isDeleted;

        public TableEntry(K key, V value) {
            super(key, value);
            setDeleted(false);
        }

        public boolean isDeleted() {
            return isDeleted;
        }

        public void setDeleted(boolean deleted) {
            isDeleted = deleted;
        }
    }
}