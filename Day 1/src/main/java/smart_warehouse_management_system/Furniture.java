package smart_warehouse_management_system;

class Furniture extends WarehouseItem {
    Furniture(String name) {
        super(name);
    }

    @Override
    void displayDetails() {
        System.out.println("Furniture Item: " + name);
    }
}
