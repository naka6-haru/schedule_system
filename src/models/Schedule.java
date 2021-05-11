package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "schedules")
@NamedQueries({
    @NamedQuery(
        name = "getDateAllSchedules",
        query = "SELECT s FROM Schedule AS s WHERE s.schedule_date = :schedule_date ORDER BY s.id DESC"
    ),
    @NamedQuery(
        name = "getDateAllSchedulesCount",
        query = "SELECT COUNT(s) FROM Schedule AS s WHERE s.schedule_date = :schedule_date"
    ),
    @NamedQuery(
        name = "getMyAllSchedule",
        query = "SELECT s FROM Schedule AS s WHERE s.user = :user ORDER BY s.id DESC"
    ),
    @NamedQuery(
        name = "getMyAllScheduleCount",
        query = "SELECT COUNT(s) FROM Schedule AS s WHERE s.user = :user"
        )
})
@Entity
public class Schedule {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "schedule_date_id",nullable = false)
    private Schedule_date schedule_date;

    @Column(name = "monday",nullable = false)
    private String monday;

    @Column(name = "tuesday",nullable = false)
    private String tuesday;

    @Column(name = "wednesday",nullable = false)
    private String wednesday;

    @Column(name = "thursday",nullable = false)
    private String thursday;

    @Column(name = "friday",nullable = false)
    private String friday;

    @Column(name = "saturday",nullable = false)
    private String saturday;

    @Column(name = "sunday",nullable = false)
    private String sunday;

    @Column(name = "created_at",nullable = false)
    private Timestamp created_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Schedule_date getSchedule_date() {
        return schedule_date;
    }

    public void setSchedule_date(Schedule_date schedule_date) {
        this.schedule_date = schedule_date;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }


}
