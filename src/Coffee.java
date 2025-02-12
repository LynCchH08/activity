
public class Coffee {
    public String name;
    public String type;
    public String size;
    public double price;
    public String roastLevel;
    public String origin;
    public boolean isDecaf;
    public int stock;
    public String[] flavorNotes;
    public String brewMethod;

    public Coffee(String name, String type, String size, double price, String roastLevel, String origin, boolean isDecaf, int stock, String[] flavorNotes, String brewMethod) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.price = price;
        this.roastLevel = roastLevel;
        this.origin = origin;
        this.isDecaf = isDecaf;
        this.stock = stock;
        this.flavorNotes = flavorNotes;
        this.brewMethod = brewMethod;
    }

    public double calculatePrice(String size) {
        double finalPrice = this.price;
        if (size.equalsIgnoreCase("Medium")) {
            finalPrice += 1.0; 
        } else if (size.equalsIgnoreCase("Large")) {
            finalPrice += 2.0;
        }
        return finalPrice;
    }

    public boolean checkStock() {
        return this.stock > 0;
    }

    public void addFlavor(String note) {
        String[] newFlavorNotes = new String[flavorNotes.length + 1];
        System.arraycopy(flavorNotes, 0, newFlavorNotes, 0, flavorNotes.length);
        newFlavorNotes[flavorNotes.length] = note;
        flavorNotes = newFlavorNotes;
    }

    // Method to update stock quantity
    public void updateStock(int quantity) {
        this.stock += quantity;
    }

    // Method to describe the coffee
    public String describe() {
        StringBuilder description = new StringBuilder();
        description.append("A ").append(roastLevel).append(" roast coffee from ").append(origin)
                .append(" with flavor notes of ");
        for (String note : flavorNotes) {
            description.append(note).append(" ");
        }
        description.append("brewed using ").append(brewMethod).append(" method.");
        return description.toString();
    }

    // Method to set whether the coffee is decaffeinated
    public void setDecaf(boolean isDecaf) {
        this.isDecaf = isDecaf;
    }

    // Method to change the roast level of the coffee
    public void changeRoastLevel(String newRoastLevel) {
        this.roastLevel = newRoastLevel;
    }

    // Method to apply a discount to the price
    public void discount(double percentage) {
        this.price = this.price - (this.price * (percentage / 100));
    }
}
