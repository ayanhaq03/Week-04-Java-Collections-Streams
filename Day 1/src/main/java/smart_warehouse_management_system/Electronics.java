package smart_warehouse_management_system;

// Subclasses for different item types
class Electronics extends WarehouseItem {
    Electronics(String name) {
        super(name);
    }

    @Override
    void displayDetails() {
        System.out.println("Electronics Item: " + name);
    }
}
