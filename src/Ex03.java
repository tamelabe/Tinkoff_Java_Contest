import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cardsCount = sc.nextInt();
        sc.nextLine();
        char[] currentSequence = sc.nextLine().toCharArray();
        char[] requiredSequence = sc.nextLine().toCharArray();
        sc.close();

        int startPos = findStartPos(currentSequence, requiredSequence, cardsCount);
        if (startPos == -1) {
            System.out.println("YES");
            return;
        }
        int endPos = findEndPos(currentSequence, requiredSequence, cardsCount);

        int length = endPos - startPos + 1;
        for (int i = startPos, k = 0; k < length; ++i, ++k) {
            boolean flag = false;
            for (int j = startPos; j < endPos; ++j) {
                if (currentSequence[j] > currentSequence[j + 1]) {
                    char temp = currentSequence[j];
                    currentSequence[j] = currentSequence[j + 1];
                    currentSequence[j + 1] = temp;
                    flag = true;
                }
                if (!flag) break;
            }
        }
        for (int i = 0; i < cardsCount; ++i) {
            if (currentSequence[i] != requiredSequence[i]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    private static int findStartPos(char[] currentSequence, char[] requiredSequence, int cardsCount) {
        for (int i = 0; i < cardsCount; ++i) {
            if (currentSequence[i] != requiredSequence[i]) { return i; }
        }
        return -1;
    }

    private static int findEndPos(char[] currentSequence, char[] requiredSequence, int cardsCount) {
        for (int i = cardsCount - 1; i >= 0; --i) {
            if (currentSequence[i] != requiredSequence[i]) { return i; }
        }
        return -1;
    }
}
