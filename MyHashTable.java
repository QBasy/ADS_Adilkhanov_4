import java.util.LinkedList;

public class MyHashTable<K, V> extends HashNode
{
    private LinkedList<HashNode<K, V>>[] chainArray;
    private int M = 11;
    private int size;

    private static class HashNode<K, V>
    {
        private K key;
        private V value;

        public HashNode(K key, V value)
        {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString()
        {
            return "{" + key + " " + value + "}";
        }
    }

    public MyHashTable()
    {}
    public MyHashTable(int M)
    {
    }
    private int hash(K key)
    {
        return list.add(key);
    }
    public void put(K key, V value)
    {}
    public V get(K key)
    {}
    public V remove(K key)
    {
        return (V) list.remove(key);
    }
    public boolean contains(V value)
    {}
    public K getKey(V value)
    {}
}
