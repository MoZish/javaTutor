package com.example.restfuel.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RefuellingService {

    List<Refuelling> refuellingList = new ArrayList<>();

    public RefuellingService() {
    }

    public Optional<Refuelling> getOptionalRefuellingById(int id){
        return refuellingList.stream().filter(refuelling -> refuelling.getId()==id).findFirst();
    }

    public List<Refuelling> getRefuellingList() {
        return refuellingList;
    }

    public void setRefuellingList(List<Refuelling> refuellingList) {
        this.refuellingList = refuellingList;
    }

    public Refuelling addRefuelling(Refuelling newRefuelling) {
        //int id = refuellingService.getRefuellingList().get(refuellingService.getRefuellingList().size()-1).getId() + 1;
        newRefuelling.setId(refuellingList.size() + 1);
        this.refuellingList.add(newRefuelling);

        return refuellingList.get(refuellingList.size() - 1);
    }

    public Refuelling updateRefuellingById(Refuelling updateRefuelling, int id) {
        Optional<Refuelling> updated = getOptionalRefuellingById(id);
        if (updated.isPresent()) {
            Refuelling refuelling = updated.get();
            refuelling.setCurrentMilage(updateRefuelling.getCurrentMilage());
            refuelling.setPreviousMilage(updateRefuelling.getPreviousMilage());
            refuelling.setAmountInLitres(updateRefuelling.getAmountInLitres());
            return refuelling;
        }
        return null;
    }

    public double getTotalConsumption() {
        return refuellingList.stream().mapToDouble(refuelling -> refuelling.getAmountInLitres()).sum();
    }
}
