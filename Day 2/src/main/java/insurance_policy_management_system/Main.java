package insurance_policy_management_system;
import java.util.*;
public class Main {


    private Set<InsurancePolicy> hashSetPolicies = new HashSet<>();
    private Set<InsurancePolicy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<InsurancePolicy> treeSetPolicies = new TreeSet<>();

    public void addPolicy(InsurancePolicy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public void displayPolicies(Set<InsurancePolicy> policies) {
        for (InsurancePolicy policy : policies) {
            System.out.println(policy);
        }
    }
    public static void main(String[] args) {
        Main policyManager = new Main();

        // Creating sample policies
        Calendar cal = Calendar.getInstance();

        cal.set(2025, Calendar.JANUARY, 10);
        InsurancePolicy policy1 = new InsurancePolicy("P123", "John Doe", cal.getTime(), "Health", 5000.0);

        cal.set(2024, Calendar.MARCH, 15);
        InsurancePolicy policy2 = new InsurancePolicy("P124", "Alice Smith", cal.getTime(), "Car", 3000.0);

        cal.set(2024, Calendar.FEBRUARY, 25);
        InsurancePolicy policy3 = new InsurancePolicy("P125", "Bob Johnson", cal.getTime(), "Home", 4000.0);

        cal.set(2025, Calendar.JUNE, 5);
        InsurancePolicy policy4 = new InsurancePolicy("P126", "Emily Brown", cal.getTime(), "Life", 7000.0);

        // Adding policies
        policyManager.addPolicy(policy1);
        policyManager.addPolicy(policy2);
        policyManager.addPolicy(policy3);
        policyManager.addPolicy(policy4);

        // Display policies using different sets
        System.out.println("Policies in HashSet (unordered):");
        policyManager.displayPolicies(policyManager.hashSetPolicies);

        System.out.println("\nPolicies in LinkedHashSet (insertion order):");
        policyManager.displayPolicies(policyManager.linkedHashSetPolicies);

        System.out.println("\nPolicies in TreeSet (sorted by expiry date):");
        policyManager.displayPolicies(policyManager.treeSetPolicies);
    }
}
