class Copi {
    String name;
    String type;
    String size;
    double price;
    String roastLevel;
    String origin;
    boolean isDecaf;
    int stock;
    String[] flavorNotes;
    String brewMethod;

    public Copi(String name, String type, String size, double price, String roastLevel, String origin,
                boolean isDecaf, int stock, String[] flavorNotes, String brewMethod) {
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

    public double calculatePrice() {
        double finalPrice = price;
        if (size.equalsIgnoreCase("Medium")) {
            finalPrice += 1.0;
        } else if (size.equalsIgnoreCase("Large")) {
            finalPrice += 2.0;
        }
        return finalPrice;
    }

    public boolean checkStock() {
        return stock > 0;
    }

    public void addFlavor(String note) {
        String[] newFlavorNotes = new String[flavorNotes.length + 1];
        System.arraycopy(flavorNotes, 0, newFlavorNotes, 0, flavorNotes.length);
        newFlavorNotes[flavorNotes.length] = note;
        flavorNotes = newFlavorNotes;
    }

    public void updateStock(int quantity) {
        stock += quantity;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRoastLevel() {
        return roastLevel;
    }

    public void setRoastLevel(String roastLevel) {
        this.roastLevel = roastLevel;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public boolean isDecaf() {
        return isDecaf;
    }

    public void setDecaf(boolean isDecaf) {
        this.isDecaf = isDecaf;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String[] getFlavorNotes() {
        return flavorNotes;
    }

    public void setFlavorNotes(String[] flavorNotes) {
        this.flavorNotes = flavorNotes;
    }

    public String getBrewMethod() {
        return brewMethod;
    }

    public void setBrewMethod(String brewMethod) {
        this.brewMethod = brewMethod;
    }

    public void changeRoastLevel(String newRoastLevel) {
        this.roastLevel = newRoastLevel;
    }

    public void discount(double percentage) {
        price = price - (price * (percentage / 100));
    }
}

public class Mainn {
    public static void main(String[] args) {

        String[] espressoNotes = {"Chocolate", "Nutty"};
        Copi espressoCoffee = new Copi("Espresso", "Arabica", "Small", 200, "Dark", "Ethiopia", false, 10, espressoNotes, "Espresso");

        String[] latteNotes = {"Citrus", "Sweet"};
        Copi latteCoffee = new Copi("Latte", "Robusta", "Medium", 250, "Medium", "Brazil", true, 5, latteNotes, "Drip");

        System.out.println("Espresso Coffee Price: PHP " + espressoCoffee.calculatePrice());
        System.out.println("Is Espresso Coffee in stock? " + espressoCoffee.checkStock());
        System.out.println("Is Espresso Coffee Decaf? " + (espressoCoffee.isDecaf() ? "Yes" : "No"));
        espressoCoffee.addFlavor("Fruity");
        System.out.println("Espresso Coffee Description: " + espressoCoffee.describe());
        espressoCoffee.updateStock(5);
        System.out.println("Updated Espresso Coffee Stock: " + espressoCoffee.getStock());
        espressoCoffee.discount(10);
        System.out.println("Espresso Coffee Price after discount: PHP " + espressoCoffee.getPrice());

        System.out.println("\nLatte Coffee Price: PHP " + latteCoffee.calculatePrice());
        System.out.println("Is Latte Coffee in stock? " + latteCoffee.checkStock());
        System.out.println("Is Latte Coffee Decaf? " + (latteCoffee.isDecaf() ? "Yes" : "No"));
        latteCoffee.addFlavor("Creamy");
        System.out.println("Latte Coffee Description: " + latteCoffee.describe());
        latteCoffee.updateStock(3);
        System.out.println("Updated Latte Coffee Stock: " + latteCoffee.getStock());
        latteCoffee.changeRoastLevel("Dark");
        System.out.println("Updated Latte Coffee Roast Level: " + latteCoffee.getRoastLevel());
        latteCoffee.discount(15);
        System.out.println("Latte Coffee Price after discount: PHP " + latteCoffee.getPrice());
    }
}
