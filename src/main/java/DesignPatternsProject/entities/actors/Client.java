package DesignPatternsProject.entities.actors;

import DesignPatternsProject.entities.orders.AbstractOrderDetails;
import DesignPatternsProject.entities.orders.OrderDetails;
import org.neo4j.graphdb.Direction;
import org.springframework.data.annotation.Transient;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lucjan on 10.03.15.
 */

@NodeEntity
public class Client extends Person {

    private boolean rightLoyalty;

    @Fetch
    @RelatedTo(type = "ORDER_CLIENT", direction = Direction.BOTH)
    private Set<AbstractOrderDetails> orderStorage = new HashSet<>();

    private String accountNumber;
    private String PIN;


    public Client() {
    }



    public Client(String username, String password, String email) {
        super(username, password, email);
    }

    public Client(String username, String password, String email, String accountNumber, String PIN) throws IllegalArgumentException {
        super(username, password, email);
        if (accountNumber == null || PIN == null)
            throw new IllegalArgumentException("detect one or many null parameter pointers");
        else if (!accountNumber.matches("[0-9]{2}-[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}") || !accountNumber.matches("[0-9]{26}"))
            throw new IllegalArgumentException("accountNumber doesn't match to pattern");
        else if (!PIN.matches("[0-9]{4}"))
            throw new IllegalArgumentException("accountNumber doesn't match to pattern");
        else {
            this.accountNumber = accountNumber;
            this.PIN = PIN;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Client client = (Client) o;

        if (PIN != null ? !PIN.equals(client.PIN) : client.PIN != null) return false;
        if (accountNumber != null ? !accountNumber.equals(client.accountNumber) : client.accountNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (accountNumber != null ? accountNumber.hashCode() : 0);
        result = 31 * result + (PIN != null ? PIN.hashCode() : 0);
        return result;
    }

    public long getTotalIssuedMoney() {
        long cash = 0;
        for (AbstractOrderDetails orderDetails : orderStorage)
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


    public Set<AbstractOrderDetails> getOrderStorage() {
        return orderStorage;
    }

    public void setOrderStorage(Set<AbstractOrderDetails> orderStorage) {
        this.orderStorage = orderStorage;
    }
}
