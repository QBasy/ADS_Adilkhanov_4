import java.util.LinkedList;

public class MyHashTable<K, V>
{
    private HashNode<K, V>[] chainList;
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
        chainList = new HashNode[M];
    }
    public MyHashTable(int M)
    {
        this.M = M;
        chainList = new HashNode[M];
    }
    private int hash(K key)
    {
        int hash = key.hashCode() % M;
        return hash < 0 ? hash + M : hash;
    }
    public void put(K key, V value)
    {
    }
    public V get(K key)
    {}
    public V remove(K key)
    {
        return (V) chainList.;
    }
    public boolean contains(V value)
    {}
    public K getKey(V value)
    {
    }
}
