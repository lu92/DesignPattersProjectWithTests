package DesignPatternsProject.strategies.discounts;

/**
 * Created by lucjan on 09.06.15.
 */
public class Rebate  extends DiscountConditionStrategy{

    private long amount;    //  kwota po ktorej jest znizka
    private double percent;    //  procent zniznki

    public Rebate(long amount, double percent) throws IllegalArgumentException{
        if (amount >= 0 && percent >= 0 && percent <= 100) {
            this.amount = amount;
            this.percent = percent;
        } else
            throw new IllegalArgumentException("amount or percent can't be negative number");
    }

    @Override
    void checkConditions() {
        if (getDiscountHandler().getOrderDetails().getTotalBruttoPrice() > amount) {

            double discount = getDiscountHandler().getOrderDetails().calculatePercentDiscount(percent);

            if (discount > getDiscountHandler().getDiscountNotification().getRebate()) {
                getDiscountHandler().getDiscountNotification().setGrantedRebate(true);
                getDiscountHandler().getDiscountNotification().setRebate(discount);
            }
        }
    }
}
