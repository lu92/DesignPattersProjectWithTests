package DesignPatternsProject.strategies.discounts;

import DesignPatternsProject.entities.orders.AbstractOrderDetails;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 09.06.15.
 */
public class DiscountHandler {
    private DiscountNotification discountNotification = new DiscountNotification();
    private AbstractOrderDetails orderDetails;
    private Set<DiscountConditionStrategy> discountConditionStrategies = new HashSet<>();


    public DiscountHandler(AbstractOrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    public void addDiscountCondition(DiscountConditionStrategy ... discountConditions) {
        for (DiscountConditionStrategy discountCondition : discountConditions) {
            discountCondition.setDiscountHandler(this);
            discountConditionStrategies.add(discountCondition);
        }
        // po kazdym wlozeniu warunkow znizek wszystko jest przeliczane
        doDiscounts();
    }

    public void removeDiscountCondition(DiscountConditionStrategy ... discountConditions) {
        for (DiscountConditionStrategy discountCondition : discountConditions)
            discountConditionStrategies.remove(discountCondition);
    }


    public AbstractOrderDetails getOrderDetails() {
        return orderDetails;
    }

    public Set<DiscountConditionStrategy> getDiscountConditionStrategies() {
        return discountConditionStrategies;
    }

    public int getNumberOfDiscountConditions() {
        return discountConditionStrategies.size();
    }

    public void doDiscounts() {
        for (DiscountConditionStrategy discountConditionStrategy : discountConditionStrategies)
            discountConditionStrategy.checkConditions();
    }

    public class DiscountNotification {
        boolean isGrantedRebate;
        double rebate;
        boolean isGrantedFreeConsulting;
        boolean isGrantedRightLoyalty;

        public DiscountNotification() {
        }


        public DiscountNotification(boolean isGrantedRebate, double rebate, boolean isGrantedFreeConsulting, boolean isGrantedRightLoyalty) {
            this.isGrantedRebate = isGrantedRebate;
            this.rebate = rebate;
            this.isGrantedFreeConsulting = isGrantedFreeConsulting;
            this.isGrantedRightLoyalty = isGrantedRightLoyalty;
        }


        public double getRebate() {
            return rebate;
        }

        public void setRebate(double rebate) {
            this.rebate = rebate;
        }

        public boolean isGrantedRebate() {
            return isGrantedRebate;
        }

        public void setGrantedRebate(boolean isGrantedRebate) {
            this.isGrantedRebate = isGrantedRebate;
        }

        public boolean isGrantedFreeConsulting() {
            return isGrantedFreeConsulting;
        }

        public void setGrantedFreeConsulting(boolean isGrantedFreeConsulting) {
            this.isGrantedFreeConsulting = isGrantedFreeConsulting;
        }

        public boolean isGrantedRightLoyalty() {
            return isGrantedRightLoyalty;
        }

        public void setGrantedRightLoyalty(boolean isGrantedRightLoyalty) {
            this.isGrantedRightLoyalty = isGrantedRightLoyalty;
        }

        @Override
        public String toString() {
            return "DiscountNotification{" +
                    "isGrantedRebate=" + isGrantedRebate +
                    ", rebate=" + rebate +
                    ", isGrantedFreeConsulting=" + isGrantedFreeConsulting +
                    ", isGrantedRightLoyalty=" + isGrantedRightLoyalty +
                    '}';
        }
    }

    public DiscountNotification getDiscountNotification() {
        return discountNotification;
    }
}
