import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyHashTable<Integer, String> ht = new MyHashTable<>();
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        int a = scanner.nextInt();
        ht.put(a , n);
        System.out.println(ht.getKey(n));
    }
}
