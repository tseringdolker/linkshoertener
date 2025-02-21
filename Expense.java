import java.time.LocalDateTime;

public class Expense {
    private double amount;
    private String category;
    private String description;
    private LocalDateTime date;

    // Constructor
    public Expense(double amount, String category, String description, LocalDateTime date) {
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    // Getters
    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    // Override toString() for easy printing
    @Override
    public String toString() {
        return "Expense{" +
                "amount=" + amount +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}