package strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("D", "B", "C", "E", "A");
        System.out.println(list);
        List<String> copied = new ArrayList<>(list);

        List<String> sortedByAsc = SortByAsc(copied);
        System.out.println(sortedByAsc);

        List<String> sortedByAscWithLambda = SortByAscWithLambda (copied);
        System.out.println(sortedByAscWithLambda);

        List<String> sortedByDesc = SortByDesc(copied);
        System.out.println(sortedByDesc);

        List<String> sortedByDescWithLambda  = SortByDescWithLambda (copied);
        System.out.println(sortedByDescWithLambda);

        System.out.println(list);
    }

    static List<String> SortByAsc(List<String> list) {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return list;
    }

    static List<String> SortByAscWithLambda(List<String> list) {
        list.sort((o1, o2) -> o1.compareTo(o2));
        return list;
    }

    static List<String> SortByDesc(List<String> list) {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        return list;
    }

    static List<String> SortByDescWithLambda(List<String> list) {
        list.sort((o1, o2) -> o2.compareTo(o1));
        return list;
    }
 }
