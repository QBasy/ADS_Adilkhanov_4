public class MyHashTable<K, V>
{
    private HashNode[] chainList;
    private int M = 11;

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
        public void setNext(HashNode<K, V> next)
        {
            this.next = next;
        }
        public void setValue(V value)
        {
            this.value = value;
        }
        public void setKey(K key)
        {
            this.key = key;
        }
        public HashNode<K, V> getNext()
        {
            return next;
        }
        public K getKey()
        {
            return key;
        }

        public V getValue()
        {
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
    }
    public MyHashTable(int M)
    {
        this.M = M;
        chainList = new HashNode[M];
    }
    public int hash(K key)
    {
        return Math.abs(key.hashCode() % M);
    }
    public void put(K key, V value)
    {
        putRecursive(key, value, chainList, 0);
    }

    private void putRecursive(K key, V value, HashNode<K, V>[] chainList, int index)
    {
        if (index >= chainList.length)
        {
            return;
        }
        HashNode<K, V> newNode = new HashNode<>(key, value);
        if (chainList[index] == null)
        {
            chainList[index] = newNode;
            return;
        }
        putRecursive(key, value, chainList, index + 1);
    }

    public V get(K key)
    {
        return (V) getRecursive(key, chainList, 0);
    }

    private V getRecursive(K key, HashNode<K, V>[] chainList, int index)
    {
        if (index >= chainList.length)
        {
            return null;
        }
        HashNode<K, V> node = chainList[index];
        if (node != null && node.getKey().equals(key))
        {
            return node.getValue();
        }
        return getRecursive(key, chainList, index + 1);
    }
    public HashNode[] getBucket(K key)
    {
        int index = hash(key);
        return new HashNode[]{chainList[index]};
    }

    public V remove(K key)
    {
        return (V) removeRecursive(key, chainList, 0, null);
    }

    private V removeRecursive(K key, HashNode<K, V>[] chainList, int index, HashNode<K, V> prev)
    {
        if (index >= chainList.length)
        {
            return null;
        }
        HashNode<K, V> node = chainList[index];
        if (node != null && node.getKey().equals(key))
        {
            if (prev == null) {
                chainList[index] = node.getNext();
            } else {
                prev.setNext(node.getNext());
            }
            return node.getValue();
        }
        return removeRecursive(key, chainList, index + 1, node);
    }

    public boolean contains(V value)
    {
        return containsRecursive(value, chainList, 0);
    }

    private boolean containsRecursive(V value, HashNode<K, V>[] chainList, int index)
    {
        if (index >= chainList.length)
        {
            return false;
        }
        HashNode<K, V> node = chainList[index];
        if (node != null && node.getValue().equals(value))
        {
            return true;
        }
        return containsRecursive(value, chainList, index + 1);
    }

    public K getKey(V value)
    {
        return (K) getKeyRecursive(value, chainList, 0);
    }

    private K getKeyRecursive(V value, HashNode<K, V>[] chainList, int index)
    {
        if (index >= chainList.length)
        {
            return null;
        }
        HashNode<K, V> node = chainList[index];
        if (node != null && node.getValue().equals(value))
        {
            return node.getKey();
        }
        return getKeyRecursive(value, chainList, index + 1);
    }
    public void moveValues(K key) {
        HashNode<K, V>[] newChainList = new HashNode[M];
        moveValuesRecursive(key, chainList, newChainList, 0);
        chainList = newChainList;
    }

    private void moveValuesRecursive(K key, HashNode<K, V>[] sourceChainList, HashNode<K, V>[] destChainList, int index) {
        if (index >= sourceChainList.length) {
            return;
        }

        HashNode<K, V> node = sourceChainList[index];
        moveValuesForKey(key, node, destChainList, index);

        moveValuesRecursive(key, sourceChainList, destChainList, index + 1);
    }

    private void moveValuesForKey(K key, HashNode<K, V> node, HashNode<K, V>[] destChainList, int index) {
        if (node == null) {
            return;
        }

        if (node.getKey().equals(key))
        {
            HashNode<K, V> newNode = new HashNode<>(node.getKey(), node.getValue());
            if (destChainList[index] == null) {
                destChainList[index] = newNode;
            } else {
                HashNode<K, V> current = destChainList[index];
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(newNode);
            }
        }

        moveValuesForKey(key, node.getNext(), destChainList, index);
    }
}
