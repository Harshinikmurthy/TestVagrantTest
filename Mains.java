// Harshini K
// BMS INSTITUTE OF TECHNOLOGY AND MANAGEMENT
// 2024
// 7892516566
// harshinikmurthy@gmail.com


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Product {
    String name;
    double uPrice;
    int gst;
    int quantity;
    double totalGST;
    double totalPrice;

    Product(String name, double uPrice, int gst, int quantity) {
        this.name = name;
        this.uPrice = uPrice;
        this.gst = gst;
        this.quantity = quantity;

        this.totalGST = (uPrice *gst / 100.0) * quantity;
        this.totalPrice = uPrice * quantity;
        if (uPrice >= 500) {
            this.totalPrice *= 0.95; 
        }
    }
}

public class Mains {
    public static void main(String[] args) {
        
        List<Product> basket = new ArrayList<>();
        basket.add(new Product("Leather wallet", 1100, 18, 1));
        basket.add(new Product("Umbrella", 900, 12, 4));
        basket.add(new Product("Cigarette", 200, 28, 3));
        basket.add(new Product("Honey", 100, 0, 2));

        
        Product maxGST = Collections.max(basket, (a, b) -> Double.compare(a.totalGST, b.totalGST));

        
        double totalAmtToPay = basket.stream()
                .mapToDouble(product -> product.totalPrice + product.totalGST)
                .sum();

        
        System.out.println("Product with maximum GST: " + maxGST.name + " with GST " + maxGST.totalGST);
        System.out.println("Total amount to be paid: " + totalAmtToPay);
    }
}
