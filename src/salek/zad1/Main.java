package salek.zad1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Main {
    private static List<String> subjects = new ArrayList<>();

    public static void main(String[] args) {
        subjects.addAll(List.of("Matematyka", "WF", "Język Polski", "Geografia", "Język Niemiecki"));

        Iterator<String> iterator = subjects.iterator();
        System.out.println("Przedmioty szkolne:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

        Comparator<String> comparatorByLengthThenAlphabetical = (s1, s2) -> {
            int result = Integer.compare(s1.length(), s2.length());
            if (result == 0) result = s1.compareTo(s2);
            return result;
        };

        subjects.sort(comparatorByLengthThenAlphabetical);
        System.out.println("Posortowane przedmioty:");
        subjects.forEach(System.out::println);
        System.out.println();

        int length = 9;
        System.out.println("Lista przedmiotów o długości " + length + ":");
        findByLength(length).forEach(System.out::println);
    }

    private static List<String> findByLength(int length) {
        return subjects.stream()
                .filter(s -> s.length() == length)
                .toList();
    }
}
