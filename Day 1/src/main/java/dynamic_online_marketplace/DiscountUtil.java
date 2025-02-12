package dynamic_online_marketplace;

class DiscountUtil {
    static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.price -= product.price * (percentage / 100);
        System.out.println("Discount applied! New price: $" + product.price);
    }
}