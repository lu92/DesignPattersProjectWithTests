package DesignPatternsProject.entities.banks;

import DesignPatternsProject.entities.actors.Client;
import DesignPatternsProject.entities.orders.AbstractOrderDetails;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by lucjan on 11.06.15.
 */
public class Bank {
    private BankName bankName;
    private Map<Client, Double> bankStorage = new HashMap<>();  // klient i jego pieniadze

    public double getBalance(Client client) {
        return bankStorage.get(client);
    }

    public boolean loginToBank(String acountNumber, String PIN) {
        for (Map.Entry<Client, Double> entry : bankStorage.entrySet()) {
            if (entry.getKey().getAccountNumber().equals(acountNumber) &&
                    entry.getKey().getPIN().equals(PIN))
                return true;
        }
        return false;
    }

    public void payByCard(String acountNumber, String PIN, AbstractOrderDetails orderDetails) throws IllegalArgumentException {

    }

    class Stats {
        private Client client;
        private double cash;
        private int InvalidAttemptsOfLogin;


    }

}
