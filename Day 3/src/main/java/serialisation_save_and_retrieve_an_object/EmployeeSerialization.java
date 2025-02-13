package serialisation_save_and_retrieve_an_object;


import java.io.*;
        import java.util.ArrayList;
        import java.util.List;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String name, department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void display() {
        System.out.println(id + " " + name + " " + department + " " + salary);
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", "HR", 50000));
        employees.add(new Employee(2, "Bob", "IT", 60000));

        // Serialize
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/java/serialisation_save_and_retrieve_an_object/employees.txt"))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/java/serialisation_save_and_retrieve_an_object/employees.txt"))) {
            List<Employee> deserializedEmployees = (List<Employee>) ois.readObject();
            System.out.println("Deserialized Employees:");
            deserializedEmployees.forEach(Employee::display);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
