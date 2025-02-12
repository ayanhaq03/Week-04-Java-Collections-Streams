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
}
