package fact.it.startproject.model;

import javax.persistence.Entity;

@Entity
public class CashPayment extends Payment {
    private String name;

    public CashPayment() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
