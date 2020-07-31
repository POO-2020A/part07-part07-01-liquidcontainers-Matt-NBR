
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = 0;
        int second = 0;

        while (true) {
            System.out.println("First: " + first + "/100");
            System.out.println("Second: " + second + "/100");
            System.out.print("> ");

            String input = scan.nextLine();
            String[] parts = input.split(" ");
            if (input.equals("quit")) {
                break;
            } else if (parts[0].equals("add")) {
                int amount = Integer.valueOf(parts[1]);
                if (amount >= 0) {
                    first += amount;
                    if (first > 100) {
                        first = 100;
                    }
                }
            } else if (parts[0].equals("move")) {
                int amount = Integer.valueOf(parts[1]);
                if (amount >= 0) {
                    if (amount > first) {
                        second += first;
                        first = 0;
                    } else {
                        second += amount;
                        first -= amount;
                    }
                }
                if (second > 100) {
                    second = 100;
                }
            } else if (parts[0].equals("remove")) {
                int amount = Integer.valueOf(parts[1]);
                if (amount >= 0) {
                    second -= amount;
                    if (second < 0) {
                        second = 0;
                    }
                }
            }
        }
    }
}
