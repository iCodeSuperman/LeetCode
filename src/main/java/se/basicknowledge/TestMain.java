package se.basicknowledge;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestMain {
    @Test
    public void givenPizaOrder_whenReady_thenDeliverable() {
        Pizza testPz = new Pizza();
        testPz.setStatus(Pizza.PizzaStatus.READY);
        assertTrue(testPz.isDeliverable());
    }

}
