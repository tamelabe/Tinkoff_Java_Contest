import java.util.Scanner;
import java.util.HashMap;

public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] symbols = sc.nextLine().toCharArray();
        sc.close();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char symbol : symbols) {
            Integer newValue = map.getOrDefault(symbol, 0) + 1;
            map.put(symbol, newValue);
        }
        char[] word = "sheriff".toCharArray();
        int wordsCount = map.getOrDefault(word[0], 0);
        for (char letter : word) {
            int count = map.getOrDefault(letter, 0);
            map.put(letter, count - 1);
            if (count < wordsCount) {
                wordsCount = count;
            }
        }
        System.out.println(wordsCount);
    }
}
