import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int border1 = scanner.nextInt();
        int border2 = scanner.nextInt();

        int keysQuantity = scanner.nextInt();

        SortedMap<Integer, String> map = new TreeMap<>();
        int key = 0;
        String value = "";

        for (int i = 0; i < keysQuantity; i++) {
            key = scanner.nextInt();
            value = scanner.next();
            map.put(key, value);
        }

        for (var i: map.subMap(border1, border2 + 1).entrySet()) {
            System.out.print(i.getKey() + " ");
            System.out.print(i.getValue() + "\n");
        }
    }
}