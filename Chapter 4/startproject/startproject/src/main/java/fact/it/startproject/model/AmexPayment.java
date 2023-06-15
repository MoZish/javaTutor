package fact.it.startproject.model;

import javax.persistence.Entity;

@Entity
public class AmexPayment extends ElectronicPayment{
    private Integer pinCode;

    public AmexPayment() {
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }
}
