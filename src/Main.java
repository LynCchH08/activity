public class Main {
    public static void main(String[] args) {

        String[] espressoNotes = {"Chocolate", "Nutty"};
        Coffee espressoCoffee = new Coffee("Espresso", "Arabica", "Small", 3.50, "Dark", "Ethiopia", false, 10, espressoNotes, "Espresso");

        String[] latteNotes = {"Citrus", "Sweet"};
        Coffee latteCoffee = new Coffee("Latte", "Robusta", "Medium", 4.50, "Medium", "Brazil", true, 5, latteNotes, "Drip");

        System.out.println("Espresso Coffee Price: $" + espressoCoffee.calculatePrice(espressoCoffee.size));
        System.out.println("Is Espresso Coffee in stock? " + espressoCoffee.checkStock());
        espressoCoffee.addFlavor("Fruity");
        System.out.println("Espresso Coffee Description: " + espressoCoffee.describe());
        espressoCoffee.updateStock(5);
        System.out.println("Updated Espresso Coffee Stock: " + espressoCoffee.stock);
        espressoCoffee.discount(10); // Apply 10% discount
        System.out.println("Espresso Coffee Price after discount: $" + espressoCoffee.price);

        System.out.println("\nLatte Coffee Price: $" + latteCoffee.calculatePrice(latteCoffee.size));
        System.out.println("Is Latte Coffee in stock? " + latteCoffee.checkStock());
        latteCoffee.addFlavor("Creamy");
        System.out.println("Latte Coffee Description: " + latteCoffee.describe());
        latteCoffee.updateStock(3);
        System.out.println("Updated Latte Coffee Stock: " + latteCoffee.stock);
        latteCoffee.changeRoastLevel("Dark");
        System.out.println("Updated Latte Coffee Roast Level: " + latteCoffee.roastLevel);
        latteCoffee.discount(15); // Apply 15% discount
        System.out.println("Latte Coffee Price after discount: $" + latteCoffee.price);
    }
}
