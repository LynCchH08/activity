public class Coffee {
    private String name;
    private String type;
    private String size;
    private double price;
    private String roastLevel;
    private String origin;
    private boolean isDecaf;
    private int stock;
    private String[] flavorNotes;
    private String brewMethod;

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

    public void updateStock(int quantity) {
        this.stock += quantity;
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
        this.price = this.price - (this.price * (percentage / 100));
    }
}
