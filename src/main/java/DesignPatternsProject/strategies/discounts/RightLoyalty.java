package DesignPatternsProject.strategies.discounts;

/**
 * Created by lucjan on 09.06.15.
 */
public class RightLoyalty extends DiscountConditionStrategy {

    private final long AMOUNT = 2 * 1000 * 1000; // kwota po ktorej przyznawany jest status stalego klienta

    public RightLoyalty() {
    }

    @Override
    void checkConditions() {
//        if (getDiscountHandler().getOrderDetails().getClient().getTotalIssuedMoney() > AMOUNT)
//            getDiscountHandler().getDiscountNotification().setGrantedRightLoyalty(true);
        if (getDiscountHandler().getOrderDetails().getTotalBruttoPrice() > AMOUNT)
            getDiscountHandler().getDiscountNotification().setGrantedRightLoyalty(true);
    }
}
