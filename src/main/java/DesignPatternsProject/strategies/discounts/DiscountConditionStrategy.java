package DesignPatternsProject.strategies.discounts;


/**
 * Created by lucjan on 06.06.15.
 */
public abstract class DiscountConditionStrategy {
    private DiscountHandler discountHandler;

    public DiscountConditionStrategy() {
    }

    abstract void checkConditions();

    public DiscountHandler getDiscountHandler() {
        return discountHandler;
    }

    public void setDiscountHandler(DiscountHandler discountHandler) {
        this.discountHandler = discountHandler;
    }
}
