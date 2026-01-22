package documents;

public abstract class WarrantyPolicy {

    private String policyName;
    private int warrantyDays;

    protected WarrantyPolicy(String policyName, int warrantyDays) {
        this.policyName = policyName;
        this.warrantyDays = warrantyDays;
    }

    public String getPolicyName() {
        return policyName;
    }

    public int getWarrantyDays() {
        return warrantyDays;
    }

    public boolean isCovered(int daysAfterService) {
        return daysAfterService <= warrantyDays;
    }

    @Override
    public String toString() {
        return "documents.WarrantyPolicy{" +
                "policyName='" + policyName + '\'' +
                ", warrantyDays=" + warrantyDays +
                '}';
    }
}
