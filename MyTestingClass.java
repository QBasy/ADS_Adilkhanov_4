import java.util.LinkedList;

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
        int result = 17;
        result = 31 * result + x;
        result = 31 * result + (y != null ? y.hashCode() : 0);
        return result;
    }

    public static void main(String[] args)
    {
        LinkedList<Integer> list = new LinkedList<>();
        MyHashTable<MyTestingClass, String> ht = new MyHashTable<>();
        for (int i = 0; i < 9; i++) {
            int x = i % 100;
            String y = "Value_" + i;
            MyTestingClass key = new MyTestingClass(x, y);
            ht.put(key, y);
            int index = ht.hash(key);
            list.add(index);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Bucket " + i + ": " + list.get(i) + " elements");
        }
    }
}
