import java.util.Scanner;

class Product{
    private String name;
    private double price;
    private String nutritionalFacts;
    private Category category;

    public Product(String name, double price, String nutritionalFacts, Category category) {
        this.name = name;
        this.price = price;
        this.nutritionalFacts = nutritionalFacts;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getNutritionalFacts() {
        return nutritionalFacts;
    }

    public Category getCategory() {
        return category;
    }
}

public class vendingMachine {
    private Product[][][] products;
    private double totalprice;
    private double currentamount;

    public vendingMachine() {
        products = new Product[6][6][6];

        initializeProducts();
    }

    private void initializeProducts() {

        products[0][0][0] = new Product("Chips", 1.5,
                "NutritionalFacts:160 calories, 10 grams of fat, 15g of carbs, 2 grams of protein", Category.SNACKS);
        products[1][0][0] = new Product("Candy", 1.2,
                "NutritionalFacts:  60 calories, 15 grams of carbs, and 11g of sugar", Category.SNACKS);
        products[2][0][0] = new Product("Gum", 2.0,
                "NutritionalFacts: 11 calories, 0 grams of fat, 1g of carbs, and 0 grams of protein", Category.BEVERAGES);
        products[3][0][0] = new Product("Energy Drink", 5.0,
                "NutritionalFacts: 10 calories, 0 grams of fat, 2g of carbs, and 0 grams of protein", Category.BEVERAGES);
        products[4][0][0] = new Product("Soda", 2.0,
                "NutritionalFacts: 110 calories, 0 grams of fat, 15g of carbs, and 0 grams of protein", Category.BEVERAGES);
        products[5][0][0] = new Product("Water", 3.0,
                "NutritionalFacts: 0", Category.BEVERAGES);


        totalprice = 0.0;
        currentamount = 0.0;

    }

    public void display() {

        System.out.println("Welcome to the Vending Machine!");
        System.out.println("Available Products:");
        int productNumber = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if (products[i][j][k] != null) {
                        Product product = products[i][j][k];
                        System.out.printf("(%d) %s - $%.2f - Category: %s%n",
                                productNumber, product.getName(), product.getPrice(), product.getCategory());
                        productNumber++;
                    }
                }
            }
        }
        System.out.println("(7) Exit");
    }


    public void Selection() {
        display();
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;

        while (true) {
            display();
            System.out.print("Enter the product number (1-6) or '7' to exit: ");
            String input = scanner.nextLine();

            if (input.equals("0")) {
                break;
            }

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Selected Product: Chips");
                    System.out.println("Price: $1.5");
                    System.out.println("Nutritional Facts: 160 calories, 10 grams of fat, 15g of carbs, 2 grams of protein, Category-SNACKS); ");

                    break;
                case 2:
                    System.out.println("Selected Product: Candy");
                    System.out.println("Price: $1.2");
                    System.out.println("Nutritional Facts: 60 calories, 15 grams of carbs, and 11g of sugar, Category-SNACKS");
                    break;
                case 3:
                    System.out.println("Selected Product: Gum");
                    System.out.println("Price: $2.0");
                    System.out.println("Nutritional Facts: 11 calories, 0 grams of fat, 1g of carbs, and 0 grams of protein, Category-BEVERAGES");
                    break;
                case 4:
                    System.out.println("Selected Product: Energy Drink");
                    System.out.println("Price: $5.0");
                    System.out.println("Nutritional Facts: 10 calories, 0 grams of fat, 2g of carbs, and 0 grams of protein, Category-BEVERAGES");

                    break;
                case 5: System.out.println("Selected Product: Soda");
                    System.out.println("Price: $2.0");
                    System.out.println("Nutritional Facts: 110 calories, 0 grams of fat, 15g of carbs, and 0 grams of protein, Category-BEVERAGES");
                    break;
                case 6:System.out.println("Selected Product: Water");
                    System.out.println("Price: $3.0");
                    System.out.println("Nutritional Facts: 0, Category-BEVERAGES");
                    break;
                case 7:System.out.println("Exiting...");
                    System.out.println("Thank you for your purchases!");
                    System.out.printf("Total amount: $%.2f%n", total);
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }



        }



    }
    public static void main(String[] args) {
        vendingMachine vendingMachine = new vendingMachine();
        vendingMachine.Selection();



    }

}