# Assignment 4
### Made with :heart: by Sayat Adilkhanov


---


# Main 🚀 [Link](Main.java)

```java
    public static void main(String[] args) 
    {
        MyHashTable<String, Integer> table = new MyHashTable<>();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) 
        {
            System.out.println("Enter your choice:");
            System.out.println("1. Put (key, value)\n2. Get value by key\n3. Remove by key\n4. Check if value exists\n5. Get key by value");
            System.out.println("6. Exit");

            int n = scanner.nextInt();
            switch (n)
            {
                case 1:
                    System.out.println("Enter key:");
                    String key = scanner.next();
                    System.out.println("Enter value:");
                    int value = scanner.nextInt();
                    table.put(key, value);
                    System.out.println("Value inserted)))");
                    break;
                case 2:
                    System.out.println("Enter key:");
                    key = scanner.next();
                    Integer result = table.get(key);
                    if (result != null) 
                    {
                        System.out.println("Value: " + result);
                    } else 
                    {
                        System.out.println("Key not found(((");
                    }
                    break;
                case 3:
                    System.out.println("Enter key:");
                    key = scanner.next();
                    Integer removedValue = table.remove(key);
                    if (removedValue != null)
                    {
                        System.out.println("Press F for value: " + removedValue);
                    } else
                    {
                        System.out.println("Key not found(((");
                    }
                    break;
                case 4:
                    System.out.println("Enter value:");
                    value = scanner.nextInt();
                    boolean contains = table.contains(value);
                    System.out.println("Value exists: " + contains);
                    break;
                case 5:
                    System.out.println("Enter value:");
                    value = scanner.nextInt();
                    String foundKey = table.getKey(value);
                    if (foundKey != null)
                    {
                        System.out.println("Key: " + foundKey);
                    } else 
                    {
                        System.out.println("No such value(((.");
                    }
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Don't be a 🤡");
            }
            System.out.println();
        }

        System.out.println("Good bye)))");
    }
```

---

# Class MyHashTable 🚀 [Link](MyHashTable.java)

```java
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
        public void setNext(HashNode<K, V> next) {
            this.next = next;
        }
        public void setValue(V value) {
            this.value = value;
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
    }
    public MyHashTable(int M)
    {
        this.M = M;
        chainList = new HashNode[M];
    }
```

## Method hash

```java
    public int hash(K key)
    {
        return Math.abs(key.hashCode() % M);
    }
```

## Method put & putRecursive

```java
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
```

## Method get & getRecursive

```java
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
```

## Method remove & removeRecursive

```java
    public V remove(K key)
    {
        return (V) removeRecursive(key, chainList, 0, null);
    }

    private V removeRecursive(K key, HashNode<K, V>[] chainList, int index, HashNode<K, V> prev) {
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
```

## Method conatins and containsRecursive

```java
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
```

## Method getKey and getKeyRecursive

```java
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
```

---

# Class MyTestingClass 🚀 [Link](MyTestingClass.java)

```java
    private int x;
    private String y;

    public MyTestingClass(int x, String y)
    {
        this.x = x;
        this.y = y;
    }
    @Override
    public int hashCode()
    {
        int result = 21;
        result = 47 * result + x;
        result = 47 * result + (y != null ? y.hashCode() : 0);
        return result;
    }

    static LinkedList<Integer> list = new LinkedList<>();
    static MyHashTable<MyTestingClass, String> ht = new MyHashTable<>();
    static Random random = new Random();
    public static void main(String[] args)
    {
        int count = 999999999;
        addElements(ht, list, count);
        printBucketSizes(list);
    }
```

## Method addElement

```java
    private static void addElements(MyHashTable<MyTestingClass, String> ht, LinkedList<Integer> list, int count) 
    {
        if (count == 0) 
        {
            return;
        }
        int x = random.nextInt(100);
        String y = "Element_" + x;
        MyTestingClass key = new MyTestingClass(x, y);
        ht.put(key, y);
        int index = ht.hash(key);
        list.add(index);
        try
        {
            addElements(ht, list, count - 1);
        } catch(StackOverflowError e){
            System.err.println("ouch!");
        }
    }
```

## Method printBucketSize

```java
    private static void printBucketSizes(LinkedList<Integer> list) 
    {
        int sum = 0;
        for (int index = 0; index < list.size(); index++) {
            System.out.println("Bucket " + index + ": " + list.get(index) + " elements");
            sum = sum + list.get(index);
            if (sumContainsTenThousand(sum))
            {
                System.out.println("sum of all elements equal to " + sum);
                break;
            }
        }
    }
```

## Method sumContainsTenThousand

```java
    private static boolean sumContainsTenThousand(int sum)
    {
        if (sum >= 10000)
            return true;
        else return false;
    }
```
