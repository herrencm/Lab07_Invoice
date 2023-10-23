import java.util.ArrayList;

public class Invoice {
    private String title;
    private String customerAddress;
    private ArrayList<LineItem> lineItems;
    private double totalAmountDue;

    public Invoice(String title, String customerAddress) {
        this.title = title;
        this.customerAddress = customerAddress;
        this.lineItems = new ArrayList<LineItem>();
        this.totalAmountDue = 0.0;
    }

    public void addLineItem(LineItem item) {
        this.lineItems.add(item);
        this.totalAmountDue += item.getTotal();
    }

    public double getTotalAmountDue() {
        return this.totalAmountDue;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.title + "\n");
        builder.append(this.customerAddress + "\n");
        builder.append("| Item | Qty | Price | Total |\n");
        for (LineItem item : this.lineItems) {
            builder.append("| " + item.getProduct().getName() + " | " + item.getQuantity() + " | " + item.getProduct().getUnitPrice() + " | " + item.getTotal() + " |\n");
        }
        builder.append("\nAMOUNT DUE: $" + this.totalAmountDue);
        return builder.toString();
    }
}

