package smart_warehouse_management_system;

// Generic Storage class
import java.util.*;

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    void addItem(T item) {
        items.add(item);
    }

    void displayItems() {
        for (T item : items) {
            item.displayDetails();
        }
    }

    // Wildcard method to display any type of WarehouseItem
    static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.displayDetails();
        }
    }
}
