import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int volume = sc.nextInt();
            int count = sc.nextInt();
            int[] banknotes = new int[count * 2];
            for (int i = 0; i < count * 2; i += 2) {
                banknotes[i] = banknotes[i + 1] = sc.nextInt();
            }
            Arrays.sort(banknotes);
            if (banknotes[0] * 2 > volume) {
                System.out.println("-1");
            } else {
                ArrayList<Integer> solution = findSolution(volume, banknotes);
                System.out.println(solution.size());
                for (int i = 0; i < solution.size(); i++) {
                    System.out.print(solution.get(i));
                    if (i != solution.size() - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        } catch (RuntimeException e) {
            System.out.println("-1");
        }
    }
    private static ArrayList<Integer> findSolution(int volume, int[] banknotes) {
        List<Integer> indexList = new ArrayList<>();
        int sum = 0;
        int startPos = banknotes.length - 1;
        for (int i = startPos; i >= 0; --i) {
            int newSum = sum + banknotes[i];
            if (newSum < volume) {
                sum = newSum;
                indexList.add(i);
            } else if (newSum == volume) {
                sum = newSum;
                indexList.add(i);
                break;
            } else if (i == 0) {
                i = --startPos;
                sum = 0;
                indexList.clear();
            }
        }
        if (sum < volume) {
            System.out.println("-1");
            System.exit(0);
        }
        ArrayList<Integer> solution = new ArrayList<>();
        for (int i = indexList.size() - 1; i >= 0; --i) {
            solution.add(banknotes[indexList.get(i)]);
        }
        return solution;
    }
}
