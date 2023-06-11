package fact.it.startproject.model;

import javax.persistence.Entity;

@Entity
public class House extends Property{
    private boolean townhouse;

    public House() {
    }

    public boolean isTownhouse() {
        return townhouse;
    }

    public void setTownhouse(boolean townhouse) {
        this.townhouse = townhouse;
    }

    public String toString(){
        if (townhouse){
            return String.format("Townhouse (%s) with %s contract(s)", this.getCode(), this.getContractList().size());
        }else {
            return String.format("Detached house (%s) with %s contract(s)", this.getCode(), this.getContractList().size());
        }
    }
}
