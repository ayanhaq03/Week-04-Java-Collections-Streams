package dynamic_online_marketplace;

public class Main {

    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Programming", 50.0, new BookCategory());
        book.displayProduct();


        DiscountUtil.applyDiscount(book, 10);
    }
}
