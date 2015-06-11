package DesignPatternsProject.strategies.discounts;


/**
 * Created by lucjan on 09.06.15.
 */
public class FreeConsulting extends DiscountConditionStrategy {

    private int amount;

    public FreeConsulting(int amount) throws IllegalArgumentException{
        if (amount >= 0)
            this.amount = amount;
        else throw new IllegalArgumentException("amount can't be negative number");
    }


    @Override
    void checkConditions() {
        if (getDiscountHandler().getOrderDetails().getTotalBruttoPrice() >= amount ) {
            getDiscountHandler().getDiscountNotification().setGrantedFreeConsulting(true);
        }
    }
}
