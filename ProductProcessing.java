import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class ProductProcessing {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", "Electronics", 1200.00));
        products.add(new Product("Phone", "Electronics", 800.00));
        products.add(new Product("Shirt", "Clothing", 30.00));
        products.add(new Product("Jeans", "Clothing", 50.00));
        products.add(new Product("Headphones", "Electronics", 150.00));
        products.add(new Product("Jacket", "Clothing", 100.00));
        products.add(new Product("Tablet", "Electronics", 400.00));

        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        
        System.out.println("Products grouped by category:");
        productsByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });

        System.out.println("\nMost expensive product in each category:");
        Map<String, Optional<Product>> mostExpensiveProductByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))));

        mostExpensiveProductByCategory.forEach((category, product) -> 
            System.out.println(category + ": " + product.get()));
        
        double averagePrice = products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0);

        System.out.println("\nAverage price of all products: " + averagePrice);
    }
}

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', category='" + category + "', price=" + price + '}';
    }
}
