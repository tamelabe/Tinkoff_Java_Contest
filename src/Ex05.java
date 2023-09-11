import java.util.ArrayList;
import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int gCount = sc.nextInt();
        int qCount = sc.nextInt();
        sc.nextLine();
        ArrayList<Ghost> ghosts = new ArrayList<>();
        ghosts.add(null);
        ArrayList<ArrayList<Integer>> gangsDB = new ArrayList<>();
        gangsDB.add(new ArrayList<>());
        for (int i = 1; i <= gCount; ++i) {
            Ghost newGhost = new Ghost();
            ghosts.add(newGhost);
            gangsDB.add(new ArrayList<>());
            gangsDB.get(i).add(newGhost.getGang());
        }
        for (int i = 0; i < qCount; ++i) {
            int qNumber = sc.nextInt();
            Ghost x = ghosts.get(sc.nextInt());
            if (qNumber == 1) {
                Ghost y = ghosts.get(sc.nextInt());
                unionGangs(ghosts, x, y, gangsDB);
            } else if (qNumber == 2) {
                Ghost y = ghosts.get(sc.nextInt());
                if (x.getGang() == y.getGang()) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else if (qNumber == 3) {
                System.out.println(x.getGangCount());
            }
            sc.nextLine();
        }
    }

    private static void unionGangs(ArrayList<Ghost> ghosts, Ghost x, Ghost y, ArrayList<ArrayList<Integer>> gangsDB) {
        if (x.getGang() != y.getGang()) {
            int oldXGang = x.getGang();
            int oldYGang = y.getGang();
            int newGang = GenId.getInstance().generateId();
            gangsDB.add(new ArrayList<>());
            for (Integer ghost : gangsDB.get(oldXGang)) {
                ghosts.get(ghost).changeGang(newGang);
                gangsDB.get(newGang).add(ghost);
            }
            for (Integer ghost : gangsDB.get(oldYGang)) {
                ghosts.get(ghost).changeGang(newGang);
                gangsDB.get(newGang).add(ghost);
            }
            gangsDB.get(oldXGang).clear();
            gangsDB.get(oldYGang).clear();
        }
    }
}

class Ghost {
    public Ghost() {
        gang = GenId.getInstance().generateId();
        gangCount = 1;
    }
    public void changeGang(int newGang) {
        gang = newGang;
        ++gangCount;
    }
    public int getGang() {
        return gang;
    }
    public int getGangCount() { return gangCount; }
    private int gang;
    private int gangCount;
}

class GenId {
    public static GenId getInstance() {
        if (generator == null) { generator = new GenId(); }
        return generator;
    }
    public int generateId() { return ++counter; }
    private GenId() { counter = 0; }
    private static GenId generator;
    private static int counter;
}
