package documents;

public class StandardWarrantyPolicy extends WarrantyPolicy {

    private boolean coversParts;

    public StandardWarrantyPolicy() {
        super("Standard Warranty", 30);
        this.coversParts = true;
    }

    public boolean isCoversParts() {
        return coversParts;
    }

    @Override
    public String toString() {
        return "documents.StandardWarrantyPolicy{" +
                "policyName='" + getPolicyName() + '\'' +
                ", warrantyDays=" + getWarrantyDays() +
                ", coversParts=" + coversParts +
                '}';
    }
}
