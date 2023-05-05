import java.util.LinkedList;

public class MyHashTable<K, V>
{
    private LinkedList<HashNode<K, V>>[] chainList;
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
    {
        chainList = new LinkedList[M];
        for (int i = 0; i < M; i++)
        {
            chainList[i] = new LinkedList<>();
        }
        size = 0;
    }
    public MyHashTable(int M)
    {
        this.M = M;
        chainList = new LinkedList[M];
        for (int i = 0; i < M; i++)
        {
            chainList[i] = new LinkedList<>();
        }
        size = 0;
    }
    private int hash(K key)
    {
        return key.hashCode() % M;
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
