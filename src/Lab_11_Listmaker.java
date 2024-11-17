import java.util.ArrayList;
import java.util.Scanner;

public class Lab_11_Listmaker {
    private static ArrayList<String> list = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String menuChoice;
        do {
            displayMenu();
            menuChoice = SafeInput.getRegExString(scanner, "Enter a choice: [AaDdIiPpQq]", "[AaDdIiPpQq]").toUpperCase();

            switch (menuChoice) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm(scanner, "Are you sure you want to quit?")) {
                        System.out.println("Goodbye!");
                        return;
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (true);
    }

    private static void displayMenu() {
        System.out.println("\n--- List Menu ---");
        System.out.println("A - Add an item");
        System.out.println("D - Delete an item");
        System.out.println("I - Insert an item");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit the program");
    }

    private static void printList() {
        System.out.println("\n--- Current List ---");
        if (list.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%d: %s\n", i + 1, list.get(i));
            }
        }
    }

    private static void addItem() {
        String newItem = SafeInput.getNonEmptyString(scanner, "Enter the item to add: ");
        list.add(newItem);
        System.out.println("Item added to the list.");
    }

    private static void deleteItem() {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }
        printList();
        int indexToDelete = SafeInput.getRangedInt(scanner, "Enter the number of the item to delete: ", 1, list.size()) - 1;
        list.remove(indexToDelete);
        System.out.println("Item deleted.");
    }

    private static void insertItem() {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Adding as the first item.");
            addItem();
            return;
        }
        printList();
        int position = SafeInput.getRangedInt(scanner, "Enter the position to insert the item (1 to " + (list.size() + 1) + "): ", 1, list.size() + 1) - 1;
        String newItem = SafeInput.getNonEmptyString(scanner, "Enter the item to insert: ");
        list.add(position, newItem);
        System.out.println("Item inserted into the list.");
    }
}