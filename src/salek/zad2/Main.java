package salek.zad2;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Comparator<Worker> comparatorByLastNameThenByFirstNameThenByAge = (w1, w2) -> {
            int result = w1.lastName().compareTo(w2.lastName());
            if (result == 0) result = w1.firstName().compareTo(w2.firstName());
            if (result == 0) result = Integer.compare(w1.age(), w2.age());
            return result;
        };

        TreeMap<Worker, String> workers = new TreeMap<>(comparatorByLastNameThenByFirstNameThenByAge);
        var worker1 = new Worker("Kowalski", "Jan", 52, "Spawacz");
        var worker3 = new Worker("Nowocień", "Wojciech", 18, "Programista");
        var worker2 = new Worker("Chmiel", "Oskar", 25, "Kucharz");
        var worker4 = new Worker("Szwajka", "Szymon", 37, "Budowlaniec");
        var worker5 = new Worker("Matejko", "Jan", 45, "Nauczyciel");
        var worker6 = new Worker("Mazur", "Olaf", 31, "Malarz");

        workers.put(worker1, worker1.role());
        workers.put(worker2, worker2.role());
        workers.put(worker3, worker3.role());
        workers.put(worker4, worker4.role());
        workers.put(worker5, worker5.role());
        workers.put(worker6, worker6.role());

        System.out.println("Zestawienie:");
        for (var entry : workers.entrySet()) {
            System.out.println("Klucz: " + entry.getKey() + " -  Zawód: " + entry.getValue());
        }
        System.out.println();

        var role = "Nauczyciel";
        System.out.println("Pracownicy dla stanowiska " + role + ":");
        printWorkersByRole(role, workers);
    }

    private static void printWorkersByRole(String role, Map<Worker, String> workers) {
        workers.keySet().stream()
                .filter(w -> w.role().equals(role))
                .forEach(System.out::println);
    }
}
