import java.util.Scanner;

public class SafeInput {
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String input;
        do {
            System.out.print(prompt);
            input = pipe.nextLine();
            if (input.matches(regEx)) {
                return input;
            }
            System.out.println("Invalid input. Try again.");
        } while (true);
    }

    public static String getNonEmptyString(Scanner pipe, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = pipe.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input cannot be empty. Try again.");
        } while (true);
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int input;
        do {
            System.out.print(prompt);
            while (!pipe.hasNextInt()) {
                System.out.println("Invalid input. Enter a number.");
                pipe.nextLine();
            }
            input = pipe.nextInt();
            pipe.nextLine(); // Clear the buffer
            if (input >= low && input <= high) {
                return input;
            }
            System.out.println("Number out of range. Try again.");
        } while (true);
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String input;
        do {
            System.out.print(prompt + " [Y/N]: ");
            input = pipe.nextLine().trim().toUpperCase();
            if (input.equals("Y")) {
                return true;
            } else if (input.equals("N")) {
                return false;
            }
            System.out.println("Invalid input. Enter Y or N.");
        } while (true);
    }
}