import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static LinkedList<Integer> list = new LinkedList<>();
    static MyHashTable<MyTestingClass, String> ht = new MyHashTable<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("1 - put");
        int a = 0;
        while (a == 0) {
            if (sc.nextInt() == 1) {
                int b = 0;
                while (b == 0) {
                    addElementsRecursive(ht, list, sc.nextInt());
                    printBucketSizesRecursive(list, 0);
                    System.out.println("go back to the selection?\n 0 - yes\n 1 - no");
                    a = sc.nextInt();
                    System.out.println("2 - getKey, 3 - get, 4 - remove");
                    switch (sc.nextInt()) {
                        case 2:
                            ht.getKey(sc.next());
                            System.out.println("go back to the selection?\n 0 - yes\n 1 - no");
                            b = sc.nextInt();
                        case 3:
                            ht.getKey(sc.next());
                            System.out.println("go back to the selection?\n 0 - yes\n 1 - no");
                            b = sc.nextInt();
                        case 4:
                            String y = "smthg";
                            MyTestingClass key = new MyTestingClass(sc.nextInt(), y);
                            ht.remove(key);
                            System.out.println("go back to the selection?\n 0 - yes\n 1 - no");
                            b = sc.nextInt();
                        case 5:
                            ht.contains(sc.next());
                            System.out.println("go back to the selection?\n 0 - yes\n 1 - no");
                            b = sc.nextInt();
                    }
                }
            }
        }
    }

    private static void addElementsRecursive(MyHashTable<MyTestingClass, String> ht, LinkedList<Integer> list, int count) {
        if (count == 0) {
            return;
        }
        Random random = new Random();
        int x = random.nextInt(100);
        String y = sc.next();
        MyTestingClass key = new MyTestingClass(x, y);
        ht.put(key, y);
        int index = ht.hash(key);
        list.add(index);

        addElementsRecursive(ht, list, count - 1);
    }

    private static void printBucketSizesRecursive(LinkedList<Integer> list, int index) {
        if (index >= list.size()) {
            return;
        }

        System.out.println("Bucket " + index + ": " + list.get(index) + " elements");

        printBucketSizesRecursive(list, index + 1);
    }
}