package DesignPatternsProject.entities.banks;

import DesignPatternsProject.entities.actors.Client;
import DesignPatternsProject.entities.orders.AbstractOrderDetails;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * Created by lucjan on 11.06.15.
 */
public class Bank {
    private BankName bankName;
    private Set<ClientStats> clientStorage = new HashSet<>();

    public double getBalance(Client client) throws IllegalArgumentException {
        for (ClientStats clientStats : clientStorage)
            if (clientStats.getClient().equals(client))
                return clientStats.getCash();
        throw new IllegalArgumentException("client doesn't have account in bank");
    }

    public boolean loginToBank(String acountNumber, String PIN) {
        for (ClientStats clientStats : clientStorage) {
            if (clientStats.getClient().getAccountNumber().equals(acountNumber) &&
                    clientStats.getClient().getPIN().equals(PIN))
                return true;
        }
        return false;
    }

    public void payByCard(String acountNumber, String PIN, AbstractOrderDetails orderDetails) throws IllegalArgumentException {

    }

    class ClientStats {
        private Client client;
        private double cash;
        private int InvalidAttemptsOfLogin;

        public ClientStats(Client client, double cash, int invalidAttemptsOfLogin) {
            this.client = client;
            this.cash = cash;
            InvalidAttemptsOfLogin = invalidAttemptsOfLogin;
        }

        public Client getClient() {
            return client;
        }

        public void setClient(Client client) {
            this.client = client;
        }

        public double getCash() {
            return cash;
        }

        public void setCash(double cash) {
            this.cash = cash;
        }

        public int getInvalidAttemptsOfLogin() {
            return InvalidAttemptsOfLogin;
        }

        public void setInvalidAttemptsOfLogin(int invalidAttemptsOfLogin) {
            InvalidAttemptsOfLogin = invalidAttemptsOfLogin;
        }
    }

}
