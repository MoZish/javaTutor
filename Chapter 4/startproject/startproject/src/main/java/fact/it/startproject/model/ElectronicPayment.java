package fact.it.startproject.model;

import javax.persistence.Entity;

@Entity
public class ElectronicPayment extends Payment {
    private String clientName, clientAccount;

    public ElectronicPayment() {
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(String clientAccount) {
        this.clientAccount = clientAccount;
    }
}
