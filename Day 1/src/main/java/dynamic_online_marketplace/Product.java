package dynamic_online_marketplace;

// Generic Product class
class Product<T extends ProductCategory> {
    String productName;
    double price;
    T category;

    Product(String productName, double price, T category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    void displayProduct() {
        System.out.println(productName + " | Category: " + category.categoryName + " | Price: $" + price);
    }
}
