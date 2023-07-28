package app.task_3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static AtomicInteger counter = new AtomicInteger(0);
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String title;
        LinkedHashMap<String, String> contacts = getData(sc);
        title = "Initial contacts:";
        getOutput(title, contacts);
        title = "Updated contacts:";
        getOutput(title, updateList(contacts));

    }

    private static LinkedHashMap<String, String> getData(Scanner sc) {

        System.out.println("\nEnter 4 different contact's names and it's e-mails: ");
        LinkedHashMap<String, String> contacts = new LinkedHashMap<>();
        for (int i = 0; i < 4; i++) {
            counter.incrementAndGet();
            System.out.print("\n" + counter + ")" + " name: ");
            String name = sc.nextLine();

            System.out.print("e-mail: ");
            String email = sc.nextLine();

            contacts.putIfAbsent(name, email);
        }
        return contacts;
    }

    private static void getOutput(String title, LinkedHashMap<String, String> map) {
        counter.set(0);
        System.out.println("\n" + title);
        for (Map.Entry<String, String> list : map.entrySet()) {
            counter.incrementAndGet();
            System.out.println(counter + ") " + list.getKey() + " - " + list.getValue());
        }
    }

    private static LinkedHashMap<String, String> updateList(LinkedHashMap<String, String> map) {
        System.out.println("\nEnter NAME to change an E-MAIL: ");
        boolean isChanged = false;

        while (!isChanged) {
            System.out.print("contact name: ");
            String name = sc.nextLine();

            System.out.print("new e-mail: ");
            String email = sc.nextLine();

            if ((isKeyIsInTheList(map, name))) {
                map.replace(name, email);
                isChanged = true;
            } else {
                System.out.println(name + " - is not in the list. Try one more time.");
            }
        }
           return map;
}

    private static boolean isKeyIsInTheList(LinkedHashMap<String, String> map, String key) {
        return map.containsKey(key);
    }
}