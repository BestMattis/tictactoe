import org.junit.Assert;
import org.junit.Test;

public class DeliveryServiceTest {
    @Test
    public void test(){
        String foodNo = "35213981"; // Matr.Nr.
        String addr = "BestMattis"; // Github Name
        DeliveryService deliveryService = new DeliveryService();
        deliveryService.setSubContractor(new PizzaShop());
        deliveryService.deliver(foodNo,addr);
        Assert.assertEquals(PizzaShop.class, deliveryService.getSubContractor().getClass());

        deliveryService.setSubContractor(new BurgerBude());
        deliveryService.deliver(foodNo,addr);
        Assert.assertEquals(BurgerBude.class, deliveryService.getSubContractor().getClass());

        deliveryService.setSubContractor(new DoenerLaden());
        deliveryService.deliver(foodNo,addr);
        Assert.assertEquals(DoenerLaden.class, deliveryService.getSubContractor().getClass());

        deliveryService.setSubContractor(new AsiaImbiss());
        deliveryService.deliver(foodNo,addr);
        Assert.assertEquals(AsiaImbiss.class, deliveryService.getSubContractor().getClass());

        deliveryService.setSubContractor(null);
        deliveryService.deliver(foodNo,addr);
        Assert.assertNull(deliveryService.getSubContractor());
    }
}
