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
}
