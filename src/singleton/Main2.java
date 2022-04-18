package singleton;

public class Main2 {
    public static void main(String[] args) {
        Triple2 a1 = Triple2.getInstance("ALPHA");
        Triple2 b1 = Triple2.getInstance("BETA");
        Triple2 c1 = Triple2.getInstance("GAMMA");
        Triple2 a2 = Triple2.getInstance("ALPHA");
        Triple2 b2 = Triple2.getInstance("BETA");
        Triple2 c2 = Triple2.getInstance("GAMMA");

        if (a1 == a2) {
            System.out.println("a1 == a2 (" + a1 + ")");
        } else {
            System.out.println("a1 != a2");
        }

        if (b1 == b2) {
            System.out.println("b1 == b2 (" + b1 + ")");
        } else {
            System.out.println("b1 != b2");
        }

        if (c1 == c2) {
            System.out.println("c1 == c2 (" + c1 + ")");
        } else {
            System.out.println("c1 != c2");
        }

    }
}
