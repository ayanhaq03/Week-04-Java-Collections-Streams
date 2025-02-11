package smart_warehouse_management_system;

class Groceries extends WarehouseItem {
    Groceries(String name) {
        super(name);
    }

    @Override
    void displayDetails() {
        System.out.println("Grocery Item: " + name);
    }
}
