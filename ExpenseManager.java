import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
    private List<Expense> expenses;
    private static final String FILE_NAME = "expenses.txt";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    // Constructor
    public ExpenseManager() {
        expenses = new ArrayList<>();
        loadExpensesFromFile(); // Load expenses from file when the manager is created
    }

    // Add an expense
    public void addExpense(Expense expense) {
        expenses.add(expense);
        saveExpensesToFile(); // Save expenses to file after adding
    }

    // View all expenses
    public void viewAllExpenses() {
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    // View total expenses for the day
    public void viewDailyExpenses() {
        LocalDateTime now = LocalDateTime.now();
        double total = 0;
        for (Expense expense : expenses) {
            if (expense.getDate().toLocalDate().equals(now.toLocalDate())) {
                total += expense.getAmount();
            }
        }
        System.out.println("Total expenses for today: " + total);
    }

    // View total expenses for the week
    public void viewWeeklyExpenses() {
        LocalDateTime now = LocalDateTime.now();
        double total = 0;
        for (Expense expense : expenses) {
            if (expense.getDate().toLocalDate().isAfter(now.toLocalDate().minusDays(7))) {
                total += expense.getAmount();
            }
        }
        System.out.println("Total expenses for this week: " + total);
    }

    // View total expenses for the month
    public void viewMonthlyExpenses() {
        LocalDateTime now = LocalDateTime.now();
        double total = 0;
        for (Expense expense : expenses) {
            if (expense.getDate().getMonth() == now.getMonth() && expense.getDate().getYear() == now.getYear()) {
                total += expense.getAmount();
            }
        }
        System.out.println("Total expenses for this month: " + total);
    }

    // Save expenses to a file
    private void saveExpensesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Expense expense : expenses) {
                writer.write(expense.getAmount() + "," + expense.getCategory() + "," + expense.getDescription() + "," + expense.getDate().format(DATE_FORMATTER));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving expenses to file: " + e.getMessage());
        }
    }

    // Load expenses from a file
    private void loadExpensesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                double amount = Double.parseDouble(parts[0]);
                String category = parts[1];
                String description = parts[2];
                LocalDateTime date = LocalDateTime.parse(parts[3], DATE_FORMATTER);
                expenses.add(new Expense(amount, category, description, date));
            }
        } catch (IOException e) {
            System.out.println("Error loading expenses from file: " + e.getMessage());
        }
    }
}