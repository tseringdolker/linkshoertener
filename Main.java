import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseManager expenseManager = new ExpenseManager();

        while (true) {
            System.out.println("\n--- Daily Expense Tracker ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Daily Expenses");
            System.out.println("4. View Weekly Expenses");
            System.out.println("5. View Monthly Expenses");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    LocalDateTime date = LocalDateTime.now(); // Use current date and time
                    expenseManager.addExpense(new Expense(amount, category, description, date));
                    System.out.println("Expense added successfully!");
                    break;
                case 2:
                    expenseManager.viewAllExpenses();
                    break;
                case 3:
                    expenseManager.viewDailyExpenses();
                    break;
                case 4:
                    expenseManager.viewWeeklyExpenses();
                    break;
                case 5:
                    expenseManager.viewMonthlyExpenses();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}