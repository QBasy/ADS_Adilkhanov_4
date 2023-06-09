import java.util.Scanner;

public class Main
{
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
                    if (result != null) {
                        System.out.println("Value: " + result);
                    } else {
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
                    } else {
                        System.out.println("No such value(((.");
                    }
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Don't be a \uD83E\uDD21");
            }
            System.out.println();
        }
        System.out.println("Good bye)))");
    }
}
