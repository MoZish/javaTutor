package fact.it.association.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name, location;
    private double memberFee;

    @OneToMany(mappedBy = "club")
    private List<Jogger> memberList;
    @OneToMany(mappedBy = "club")
    private List<Event> eventList;

    public Club() {
    }

    public Club(String name, String location, double memberFee) {
        this.name = name;
        this.location = location;
        this.memberFee = memberFee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getMemberFee() {
        return memberFee;
    }

    public void setMemberFee(double memberFee) {
        this.memberFee = memberFee;
    }

    public List<Jogger> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Jogger> memberList) {
        this.memberList = memberList;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
