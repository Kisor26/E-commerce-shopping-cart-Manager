
import java.util.Scanner;

public class CartManager {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);


        CartItem egg = new CartItem("Egg", 10);
        CartItem milk = new CartItem("Milk", 20);
        CartItem noodles = new CartItem("Noodles", 30);

        CartItem selectedItem = null;


        while (true) {
            System.out.println("----:E_Commerece Shopping Cart Manager:--");
            System.out.println("\n1. Egg  2. Milk  3. Noodles");
            System.out.println("4. Remove item");
            System.out.println("5. + Quantity");
            System.out.println("6. - Quantity");
            System.out.println("7. Print Cart");
            System.out.println("8. Total Payable");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1 -> {
                    selectedItem = egg;
                    egg.addToCart();
                }
                case 2 -> {
                    selectedItem = milk;
                    milk.addToCart();
                }
                case 3 -> {
                    selectedItem = noodles;
                    noodles.addToCart();
                }
                case 4 -> {
                    if (selectedItem != null && selectedItem.isAddedToCart()) {
                        selectedItem.removeFromCart();
                        System.out.println("Item removed from cart");
                    } else {
                        System.out.println("Item not in cart");
                    }
                }
                case 5 -> {
                    if (selectedItem != null && selectedItem.isAddedToCart()) {
                        selectedItem.incrementQuantity();
                    } else {
                        System.out.println("Add item to cart first");
                    }
                }
                case 6 -> {
                    if (selectedItem != null && selectedItem.isAddedToCart()) {
                        selectedItem.decrementQuantity();
                    } else {
                        System.out.println("Quantity cannot be less than 1");
                    }
                }
                case 7 -> {
                    System.out.println("\n--- CART ITEMS ---");
                    if (egg.isAddedToCart()) egg.display();
                    if (milk.isAddedToCart()) milk.display();
                    if (noodles.isAddedToCart()) noodles.display();
                    System.out.println("\n");
                }
                case 8 -> {
                    double total = 0;
                    if (egg.isAddedToCart()) total += egg.getTotalPrice();
                    if (milk.isAddedToCart()) total += milk.getTotalPrice();
                    if (noodles.isAddedToCart()) total += noodles.getTotalPrice();

                    System.out.println("Total Payable Amount: " + total);
                    System.out.println("\n");
                }
                case 0 -> {
                    System.out.println("Thank you for shopping!");
                    input.close();
                    System.out.println("\n");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}

