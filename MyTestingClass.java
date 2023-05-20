import java.util.LinkedList;
import java.util.Random;

public class MyTestingClass
{
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
        int hash = 21;
        hash = 47 * hash + x;
        hash = 47 * hash + (y != null ? y.hashCode() : 0);
        return hash;
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

    private static void addElements(MyHashTable<MyTestingClass, String> ht, LinkedList<Integer> list, int count) {
        if (count == 0) {
            return;
        }
        int x = random.nextInt(100);
        String y = "Element_" + x;
        MyTestingClass key = new MyTestingClass(x, y);
        ht.put(key, y);
        int index = ht.hash(key);
        list.add(index);
        try {
            addElements(ht, list, count - 1);
        } catch(StackOverflowError e){
            System.err.println("ouch!");
        }
    }

    private static void printBucketSizes(LinkedList<Integer> list) {
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
    private static boolean sumContainsTenThousand(int sum)
    {
        if (sum >= 10000) return true;
        else return false;
    }
}
