package fact.it.startproject.model;

import javax.persistence.Entity;

@Entity
public class VisaPayment extends ElectronicPayment{
    private String cardNumber, expirationDate;

    public VisaPayment() {
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
