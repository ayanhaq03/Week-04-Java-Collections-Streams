package insurancy_policy_management_system_using_map;

import java.util.*;

class InsurancePolicy {
    private String policyNumber;
    private String policyHolder;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyHolder, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolder = policyHolder;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getPolicyHolder() {
        return policyHolder;
    }

    @Override
    public String toString() {
        return policyNumber + " | " + policyHolder + " | " + expiryDate + " | " + coverageType + " | $" + premiumAmount;
    }
}

class PolicyManagement {
    private Map<String, InsurancePolicy> policies = new HashMap<>();
    private Map<String, InsurancePolicy> orderedPolicies = new LinkedHashMap<>();
    private TreeMap<Date, InsurancePolicy> sortedByExpiry = new TreeMap<>();

    public void addPolicy(InsurancePolicy policy) {
        policies.put(policy.getPolicyNumber(), policy);
        orderedPolicies.put(policy.getPolicyNumber(), policy);
        sortedByExpiry.put(policy.getExpiryDate(), policy);
    }

    public InsurancePolicy getPolicy(String policyNumber) {
        return policies.get(policyNumber);
    }

    public List<InsurancePolicy> getExpiringSoon(int days) {
        Date now = new Date();
        Date threshold = new Date(now.getTime() + (long) days * 24 * 60 * 60 * 1000);
        return new ArrayList<>(sortedByExpiry.headMap(threshold, true).values());
    }

    public void removeExpiredPolicies() {
        Date now = new Date();
        sortedByExpiry.headMap(now, true).clear();
        policies.values().removeIf(policy -> policy.getExpiryDate().before(now));
        orderedPolicies.values().removeIf(policy -> policy.getExpiryDate().before(now));
    }
    public static void main(String[] args) {
        PolicyManagement policyManager = new PolicyManagement();

        // Creating some sample policies
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

        // Display all policies
        System.out.println("All Policies:");
        System.out.println(policyManager.getPolicy("P123"));
        System.out.println(policyManager.getPolicy("P124"));
        System.out.println(policyManager.getPolicy("P125"));
        System.out.println(policyManager.getPolicy("P126"));

        // Check expiring soon policies
        System.out.println("\nPolicies expiring in the next 60 days:");
        List<InsurancePolicy> expiringPolicies = policyManager.getExpiringSoon(60);
        for (InsurancePolicy policy : expiringPolicies) {
            System.out.println(policy);
        }

        // Remove expired policies
        System.out.println("\nRemoving expired policies...");
        policyManager.removeExpiredPolicies();

        // Display all policies after removal
        System.out.println("\nPolicies after removing expired ones:");
        System.out.println(policyManager.getPolicy("P123"));
        System.out.println(policyManager.getPolicy("P124")); // Might be removed
        System.out.println(policyManager.getPolicy("P125")); // Might be removed
        System.out.println(policyManager.getPolicy("P126"));
    }
}
