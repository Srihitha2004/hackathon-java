import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static class ClothingItem {
        List<String> sizes;
        String fit;

        ClothingItem(List<String> sizes, String fit) {
            this.sizes = sizes;
            this.fit = fit;
        }
    }

    private static Map<String, ClothingItem> clothingItems;
    private static List<String> cart;

    static {
        clothingItems = new HashMap<>();
        cart = new ArrayList<>();

        clothingItems.put("t-shirt", new ClothingItem(List.of("s", "m", "l"), "Slim"));
        clothingItems.put("jeans", new ClothingItem(List.of("28", "30", "32"), "Regular"));
        clothingItems.put("jacket", new ClothingItem(List.of("m", "l", "xl"), "Loose"));
        clothingItems.put("sneakers", new ClothingItem(List.of("8", "9", "10"), "Standard"));
        clothingItems.put("hat", new ClothingItem(List.of("s", "m", "l"), "One Size Fits All"));
        clothingItems.put("dress", new ClothingItem(List.of("s", "m", "l", "xl"), "A-Line"));
        clothingItems.put("sweater", new ClothingItem(List.of("s", "m", "l", "xl"), "Regular"));
        clothingItems.put("skirt", new ClothingItem(List.of("s", "m", "l", "xl"), "A-Line"));
        clothingItems.put("blazer", new ClothingItem(List.of("m", "l", "xl", "xxl"), "Tailored"));
        clothingItems.put("boots", new ClothingItem(List.of("7", "8", "9", "10", "11"), "Standard"));
        clothingItems.put("shirt", new ClothingItem(List.of("s", "m", "l", "xl"), "Slim"));
        clothingItems.put("shorts", new ClothingItem(List.of("28", "30", "32", "34"), "Regular"));
        clothingItems.put("polo shirt", new ClothingItem(List.of("s", "m", "l", "xl"), "Regular"));
        clothingItems.put("dress shoes", new ClothingItem(List.of("8", "9", "10", "11"), "Standard"));
        clothingItems.put("coat", new ClothingItem(List.of("m", "l", "xl", "xxl"), "Loose"));
        clothingItems.put("scarf", new ClothingItem(List.of("one size"), "One Size Fits All"));
    }
    private static void displayProducts() {
        System.out.println("Available clothing items for virtual try-on:");
        for (String itemName : clothingItems.keySet()) {
            ClothingItem item = clothingItems.get(itemName);
            System.out.println(itemName + " - Available sizes: " + item.sizes + " - Fit: " + item.fit);
        }
        System.out.println();
    }

    private static boolean tryOn(String itemName, String size) {
        itemName = itemName.trim().toLowerCase();
        ClothingItem item = clothingItems.get(itemName);
        if (item != null) {
            if (item.sizes.contains(size.trim().toLowerCase())) {
                System.out.println("Trying on " + itemName + " (Size: " + size + ", Fit: " + item.fit + ")...");
                System.out.println("Looks good! The " + itemName + " in size " + size + " fits you well.\n");
                return true;
            } else {
                System.out.println("Sorry, size " + size + " is not available for " + itemName + ".\n");
                return false;
            }
        } else {
            System.out.println("Sorry, " + itemName + " is not available.\n");
            return false;
        }
    }

    private static void addToCart(String itemName, String size) {
        cart.add(itemName + " (Size: " + size + ")");
        System.out.println(itemName + " (Size: " + size + ") has been added to your cart.\n");
    }
    private static void checkout() {
        if (!cart.isEmpty()) {
            System.out.println("Checking out the following items from your cart:");
            for (String item : cart) {
                System.out.println("- " + item);
            }
            System.out.println("Thank you for shopping with us!\n");
            cart.clear(); 
        } else {
            System.out.println("Your cart is empty.\n");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            displayProducts();
            System.out.print("Enter item to try on (or type 'q' to exit): ");
            input = scanner.nextLine().trim().toLowerCase();
            if (input.equalsIgnoreCase("q")) {
                System.out.println("Thank you for shopping with us!\n");
                break; 
            }

            System.out.print("Enter size: ");
            String size = scanner.nextLine().trim().toLowerCase();
            if (tryOn(input, size)) {
                addToCart(input, size);
            }
            System.out.print("Would you like to checkout now? (yes/no): ");
            String checkoutNow = scanner.nextLine().trim().toLowerCase();
            if (checkoutNow.equals("yes")) {
                checkout();
            } else {
                System.out.println("Thank you for shopping with us!\n");
            }
        }

        checkout();
        System.out.println("Goodbye!");
        scanner.close();
    }
}
