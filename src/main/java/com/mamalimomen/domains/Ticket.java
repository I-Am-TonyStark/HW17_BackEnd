package com.mamalimomen.domains;

import com.mamalimomen.base.controllers.utilities.InValidDataException;
import com.mamalimomen.base.domains.BaseEntity;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@SelectBeforeUpdate
@Table(name = "tbl_ticket")
@NamedQueries({
        @NamedQuery(
                name = "Ticket.findAll",
                query = "SELECT t FROM Ticket t"),
        @NamedQuery(
                name = "Ticket.findManyByUserID",
                query = "SELECT t FROM Ticket t WHERE t.ownerUserID = ?1"),
})
public class Ticket extends BaseEntity implements Comparable<Ticket> {

    @Column(name = "owner_user_ID", nullable = false, updatable = false)
    private Long ownerUserID;

    @Column(name = "owner_full_name", nullable = false, updatable = false)
    private String ownerFullName;

    @Column(name = "owner_gender", nullable = false, updatable = false)
    private Gender gender;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_travel", nullable = false, updatable = false)
    private Travel travel;

    public Long getOwnerUserID() {
        return ownerUserID;
    }

    public void setOwnerUserID(Long ownerUserID) {
        this.ownerUserID = ownerUserID;
    }

    public String getOwnerFullName() {
        return ownerFullName;
    }

    public void setOwnerFullName(String ownerFullName) throws InValidDataException {
        if (!ownerFullName.matches("([a-zA-Z]\\s?){3,}")) {
            throw new InValidDataException("FullName");
        }
        this.ownerFullName = ownerFullName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    @Override
    public String toString() {
        return String.format("%d<br/>%s<br/>%s<br/>%s", getId(), getOwnerFullName(), getGender(), getTravel());
    }

    @Override
    public int compareTo(Ticket t) {
        return this.getTravel().getTravelDate().compareTo(t.getTravel().getTravelDate());
    }
}
