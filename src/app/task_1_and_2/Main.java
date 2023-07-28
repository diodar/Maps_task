package app.task_1_and_2;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static AtomicInteger counter = new AtomicInteger(0);
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String title;
        Map<String, String> list = getData(sc);
        title = "Your product list:";
        getOutput(title, list);
        title = "Your updated product list:";
        getOutput(title, updateList(list));
        showData(list);


        sc.close();
    }

    private static Map<String, String> getData(Scanner sc) {

        System.out.println("\nEnter 5 different products and it's amount to create a list: ");
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            counter.incrementAndGet();
            System.out.print("\n" + counter + ")" + " product: ");
            String product = sc.nextLine().toLowerCase();

            System.out.print("amount: ");
            String num = sc.nextLine();

            if (!(isKeyIsInTheList(map, product)) && (isInteger(num))) {
                map.put(product, num);
            } else {
                System.out.println(product + " - is already in the list, or amount " + num + " is not a number. Try one more time.");
                i--;
                counter.decrementAndGet();
            }
        }
        return map;
    }

    private static void getOutput(String title, Map<String, String> map) {
        counter.set(0);
        System.out.println("\n" + title);
        for (Map.Entry<String, String> list : map.entrySet()) {
            counter.incrementAndGet();
            System.out.println(counter + ") " + list.getKey() + ", " + list.getValue() + " kg");
        }
    }

    private static Map<String, String> updateList(Map<String, String> map) {
        System.out.println("\nEnter a product name and it's amount that you want to add or change: ");
        boolean isChangedOrAdded = false;

        while (!isChangedOrAdded) {
            System.out.print("product name: ");
            String product = sc.nextLine().toLowerCase();

            System.out.print("amount: ");
            String num = sc.nextLine();

            if (!(isKeyIsInTheList(map, product)) && (isInteger(num))) {
                map.put(product, num);
                isChangedOrAdded = true;
            } else {
                if ((isKeyIsInTheList(map, product)) && (isInteger(num))) {
                    map.replace(product, num);
                    isChangedOrAdded = true;
                } else {
                    System.out.println(product + " - is already in the list, or amount " + num + " is not a number. Try one more time.");
                }
            }
        }
        return map;
    }

    private static void showData(Map<String, String> map) {
        System.out.println("\nEnter a product name that you want to see an amount: ");
        boolean isShowed = false;

        while (!isShowed) {
            System.out.print("product name: ");
            String product = sc.nextLine().toLowerCase();

            if (isKeyIsInTheList(map, product)) {
                System.out.println(product + " - " + map.get(product) + " kg");
                isShowed = true;
            } else {
                System.out.println(product + " - is not in the list. Try one more time.");
            }
        }
    }

    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isKeyIsInTheList(Map<String, String> map, String key) {
        return map.get(key) != null;
    }
}
