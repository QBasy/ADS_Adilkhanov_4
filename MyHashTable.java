public class MyHashTable<K, V>
{
    private HashNode[] chainList;
    private int M = 11;
    private int size;

    private static class HashNode<K, V>
    {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value)
        {
            this.key = key;
            this.value = value;
            this.next = null;
        }
        public void setNext(HashNode<K, V> next) {
            this.next = next;
        }
        public HashNode<K, V> getNext() {
            return next;
        }
        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
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
        HashNode<K, V> prev = null;
        if (node == null) {
            chainList[index] = new HashNode<>(key, value);
            size++;
        } else {
            while (node != null) {
                if (node.getKey().equals(key))
                {
                    node.value = value;
                    return;
                }
            }
        }
    }
    public V get(K key)
    {
        int index = hash(key);
        HashNode<K, V> node = chainList[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = chainList[index+1];
        }
        return null;
    }
    public V remove(K key)
    {
        int index = hash(key);
        HashNode<K, V> node = chainList[index];
        HashNode<K, V> prev = null;

        while (node != null) {
            if (node.getKey().equals(key)) {
                if (prev == null) {
                    chainList[index] = node.getNext();
                } else {
                    prev.setNext(node.getNext());
                }
                size--;
                return node.getValue();
            }

            prev = node;
            node = node.getNext();
        }

        return null;
    }
    public boolean contains(V value)
    {
        for (HashNode<K, V> node : chainList) {
            while (node != null) {
                if (node.getValue().equals(value)) {
                    return true;
                }
                node = node.getNext();
            }
        }
        return false;
    }
    public K getKey(V value) {
        for (HashNode<K, V> node : chainList) {
            while (node != null) {
                if (node.getValue().equals(value)) {
                    return node.getKey();
                }
                node = node.getNext();
            }
        }
        return null;
    }
}
