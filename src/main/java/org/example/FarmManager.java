package org.example;


import java.util.*;

public class FarmManager {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, FarmItem> farmItems = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- FARM MENU ---");
            System.out.println("1. Add Animal");
            System.out.println("2. Add Crop");
            System.out.println("3. Maintain Item");
            System.out.println("4. View All Items");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1" -> addAnimal();
                    case "2" -> addCrop();
                    case "3" -> maintainItem();
                    case "4" -> viewAllItems();
                    case "5" -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid option. Try again.");
                }
            } catch (InvalidActionException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void addAnimal() {
        System.out.print("Enter animal name: ");
        String name = scanner.nextLine();
        farmItems.put(name, new Animal(name));
        System.out.println(name + " added as Animal.");
    }

    private static void addCrop() {
        System.out.print("Enter crop name: ");
        String name = scanner.nextLine();
        farmItems.put(name, new Crop(name));
        System.out.println(name + " added as Crop.");
    }

    private static void maintainItem() throws InvalidActionException {
        System.out.print("Enter item name to maintain: ");
        String name = scanner.nextLine();

        FarmItem item = farmItems.get(name);
        if (item == null) {
            throw new InvalidActionException("Item not found in farm.");
        }

        item.maintain();
    }

    private static void viewAllItems() {
        if (farmItems.isEmpty()) {
            System.out.println("No items in the farm.");
            return;
        }

        for (FarmItem item : farmItems.values()) {
            System.out.println(item.getType() + ": " + item.getName());
        }
    }
}

