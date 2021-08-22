import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int answer = 0;
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        String firstWord = scanner.nextLine();
        String secondWord = scanner.nextLine();
        char[] firstWordChars = firstWord.toLowerCase().toCharArray();
        char[] secondWordChars = secondWord.toLowerCase().toCharArray();
        SortedMap<Character, Integer> firstMap = new TreeMap<>();
        SortedMap<Character, Integer> secondMap = new TreeMap<>();

        for (char i: firstWordChars) {
            if (!firstMap.containsKey(i)) {
                firstMap.put(i, 1);
            } else {
                firstMap.put(i, firstMap.getOrDefault(i, 0) + 1);
            }
        }

        for (char i: secondWordChars) {
            if (!secondMap.containsKey(i)) {
                secondMap.put(i, 1);
            } else {
                secondMap.put(i, secondMap.getOrDefault(i, 0) + 1);
            }
        }

        for (char i: alphabet) {
            if (!secondMap.getOrDefault(i, 0).equals(firstMap.getOrDefault(i, 0))) {
                answer += Math.abs(secondMap.getOrDefault(i, 0) - firstMap.getOrDefault(i, 0));
            }
        }
        System.out.println(answer);
    }
}