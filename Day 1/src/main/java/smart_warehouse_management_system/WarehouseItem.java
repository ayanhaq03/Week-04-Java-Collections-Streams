package smart_warehouse_management_system;

// Abstract class representing a Warehouse Item
abstract class WarehouseItem {
    String name;

    WarehouseItem(String name) {
        this.name = name;
    }

    abstract void displayDetails();
}
