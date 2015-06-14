package DesignPatternsProject.DTO;

/**
 * Created by lucjan on 14.06.15.
 */
public class DiscountNotificationDTOInfo {
    private boolean isGrantedRebate;
    private double rebate;
    private boolean isGrantedFreeConsulting;
    private boolean isGrantedRightLoyalty;

    public DiscountNotificationDTOInfo() {
    }

    public DiscountNotificationDTOInfo(boolean isGrantedRebate, double rebate, boolean isGrantedFreeConsulting, boolean isGrantedRightLoyalty) {
        this.isGrantedRebate = isGrantedRebate;
        this.rebate = rebate;
        this.isGrantedFreeConsulting = isGrantedFreeConsulting;
        this.isGrantedRightLoyalty = isGrantedRightLoyalty;
    }

    public boolean isGrantedRebate() {
        return isGrantedRebate;
    }

    public void setGrantedRebate(boolean isGrantedRebate) {
        this.isGrantedRebate = isGrantedRebate;
    }

    public double getRebate() {
        return rebate;
    }

    public void setRebate(double rebate) {
        this.rebate = rebate;
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
}
