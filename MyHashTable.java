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
        size = 0;
    }
    public MyHashTable(int M)
    {
        this.M = M;
        chainList = new HashNode[M];
        size = 0;
    }
    private int hash(K key)
    {
        int hashCode = key.hashCode();
        return Math.abs(hashCode % M);
    }
    public void put(K key, V value)
    {
        int index = hash(key);
        HashNode<K, V> node = chainList[index];
        if (node == null) {
            chainList[index] = new HashNode<K, V>(key, value)
        }
    }
    public V get(K key)
    {}
    public V remove(K key)
    {
    }
    public boolean contains(V value)
    {
    }
    public K getKey(V value)
    {

    }
}
