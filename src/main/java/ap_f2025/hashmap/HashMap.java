package ap_f2025.hashmap;

public class HashMap<K, V>
{
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Entry<K, V>[] table;
    private int size;

    public HashMap()
    {
        table = new Entry[DEFAULT_CAPACITY];
        size = 0;
    }

    public void put(K key, V value)
    {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (size >= table.length * LOAD_FACTOR) {
            resize();
        }
        int index = getIndex(key);
        Entry<K, V> entry = table[index];
        while (entry != null)
        {
            if (entry.key.equals(key))
            {
                entry.value = value;
                return;
            }
            entry = entry.next;
        }
        table[index] = new Entry<>(key, value, table[index]);
        size++;
    }

    public V get(K key)
    {
        if (key == null)
        {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int index = getIndex(key);
        Entry<K, V> entry = table[index];
        while (entry != null)
        {
            if (entry.key.equals(key))
            {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    public boolean containsKey(K key)
    {
        if (key == null)
        {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int index = getIndex(key);
        Entry<K, V> entry = table[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return true;
            }
            entry = entry.next;
        }
        return false;
    }

    public boolean remove(K key)
    {
        if (key == null)
        {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int index = getIndex(key);
        Entry<K, V> entry = table[index];
        Entry<K, V> prev = null;
        while (entry != null)
        {
            if (entry.key.equals(key))
            {
                if (prev == null)
                {
                    table[index] = entry.next;
                } else
                {
                    prev.next = entry.next;
                }
                size--;
                return true;
            }
            prev = entry;
            entry = entry.next;
        }
        return false;
    }

    public int size()
    {
        return size;
    }

    public int getLongestChain()
    {
        int longest = 0;
        for (Entry<K, V> entry : table) {
            int chainLength = 0;
            while (entry != null) {
                chainLength++;
                entry = entry.next;
            }
            if (chainLength > longest) {
                longest = chainLength;
            }
        }
        return longest;
    }

    private void resize()
    {
        Entry<K, V>[] oldTable = table;
        table = new Entry[oldTable.length * 2];
        for (Entry<K, V> entry : oldTable)
        {
            while (entry != null)
            {
                put(entry.key, entry.value);
                entry = entry.next;
            }
        }
    }

    private int getIndex(K key)
    {
        return Math.abs(key.hashCode()) % table.length;
    }

    private static class Entry<K, V>
    {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next)
        {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
