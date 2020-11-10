package com.mamalimomen.domains;

import com.mamalimomen.base.domains.BaseEntity;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@SelectBeforeUpdate
@Table(name = "tbl_travel")
@NamedQueries({
        @NamedQuery(
                name = "Travel.findAll",
                query = "SELECT t FROM Travel t"),
        @NamedQuery(
                name = "Travel.findManyByODD",
                query = "SELECT t FROM Travel t WHERE t.origin = ?1 AND t.destination = ?2 AND t.travelDate = ?3")
})
public class Travel extends BaseEntity implements Comparable<Travel> {

    @Enumerated(EnumType.STRING)
    @Column(name = "destination", nullable = false, updatable = false)
    private City destination;

    @Enumerated(EnumType.STRING)
    @Column(name = "origin", nullable = false, updatable = false)
    private City origin;

    //@Temporal(TemporalType.DATE)
    @Column(name = "travel_date", nullable = false, updatable = false)
    private Date travelDate;

    //@Temporal(TemporalType.TIME)
    @Column(name = "travel_time", nullable = false, updatable = false)
    private Time travelTime;

    public City getDestination() {
        return destination;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    public City getOrigin() {
        return origin;
    }

    public void setOrigin(City origin) {
        this.origin = origin;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    public Time getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(Time travelTime) {
        this.travelTime = travelTime;
    }

    @Override
    public String toString() {
        return String.format("%d<br/>%s<br/>%s<br/>%s<br/>%s", getId(), getOrigin(), getDestination(), getTravelDate(), getTravelTime());
    }

    @Override
    public int compareTo(Travel t) {
        return this.getTravelTime().compareTo(t.getTravelTime());
    }
}
