public class DeliveryService {
    private Caterer subContractor;
    public Caterer getSubContractor() {
        return subContractor;
    }
    public void setSubContractor(Caterer subContractor) {
        this.subContractor = subContractor;
    }
    public void deliver(String foodNo, String addr) {
        if(subContractor != null) {
            subContractor.deliver(foodNo, addr);
        }
    }
}
