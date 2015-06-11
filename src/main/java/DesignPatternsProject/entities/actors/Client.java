package DesignPatternsProject.entities.actors;

import DesignPatternsProject.entities.orders.OrderDetails;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lucjan on 10.03.15.
 */

public class Client extends Person {
    private boolean rightLoyalty;
    private Set<OrderDetails> orderStorage = new HashSet<>();

    private String accountNumber;
    private String PIN;


    public Client() {
    }

    public Client(String username, String password, String email) {
    }

    public long getTotalIssuedMoney() {
        long cash = 0;
        for (OrderDetails orderDetails : orderStorage)
            cash += orderDetails.getTotalBruttoPrice();
        return cash;
    }

    public boolean isRightLoyalty() {
        return rightLoyalty;
    }

    public void setRightLoyalty(boolean rightLoyalty) {
        this.rightLoyalty = rightLoyalty;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }
}
