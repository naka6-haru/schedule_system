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

    @Column(name = "monday1",nullable = false)
    private String monday1;

    @Column(name = "tuesday1",nullable = false)
    private String tuesday1;

    @Column(name = "wednesday1",nullable = false)
    private String wednesday1;

    @Column(name = "thursday1",nullable = false)
    private String thursday1;

    @Column(name = "friday1",nullable = false)
    private String friday1;

    @Column(name = "saturday1",nullable = false)
    private String saturday1;

    @Column(name = "sunday1",nullable = false)
    private String sunday1;

    @Column(name = "monday2",nullable = false)
    private String monday2;

    @Column(name = "tuesday2",nullable = false)
    private String tuesday2;

    @Column(name = "wednesday2",nullable = false)
    private String wednesday2;

    @Column(name = "thursday2",nullable = false)
    private String thursday2;

    @Column(name = "friday2",nullable = false)
    private String friday2;

    @Column(name = "saturday2",nullable = false)
    private String saturday2;

    @Column(name = "sunday2",nullable = false)
    private String sunday2;

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


    public String getMonday1() {
        return monday1;
    }

    public void setMonday1(String monday1) {
        this.monday1 = monday1;
    }

    public String getTuesday1() {
        return tuesday1;
    }

    public void setTuesday1(String tuesday1) {
        this.tuesday1 = tuesday1;
    }

    public String getWednesday1() {
        return wednesday1;
    }

    public void setWednesday1(String wednesday1) {
        this.wednesday1 = wednesday1;
    }

    public String getThursday1() {
        return thursday1;
    }

    public void setThursday1(String thursday1) {
        this.thursday1 = thursday1;
    }

    public String getFriday1() {
        return friday1;
    }

    public void setFriday1(String friday1) {
        this.friday1 = friday1;
    }

    public String getSaturday1() {
        return saturday1;
    }

    public void setSaturday1(String saturday1) {
        this.saturday1 = saturday1;
    }

    public String getSunday1() {
        return sunday1;
    }

    public void setSunday1(String sunday1) {
        this.sunday1 = sunday1;
    }

    public String getMonday2() {
        return monday2;
    }

    public void setMonday2(String monday2) {
        this.monday2 = monday2;
    }

    public String getTuesday2() {
        return tuesday2;
    }

    public void setTuesday2(String tuesday2) {
        this.tuesday2 = tuesday2;
    }

    public String getWednesday2() {
        return wednesday2;
    }

    public void setWednesday2(String wednesday2) {
        this.wednesday2 = wednesday2;
    }

    public String getThursday2() {
        return thursday2;
    }

    public void setThursday2(String thursday2) {
        this.thursday2 = thursday2;
    }

    public String getFriday2() {
        return friday2;
    }

    public void setFriday2(String friday2) {
        this.friday2 = friday2;
    }

    public String getSaturday2() {
        return saturday2;
    }

    public void setSaturday2(String saturday2) {
        this.saturday2 = saturday2;
    }

    public String getSunday2() {
        return sunday2;
    }

    public void setSunday2(String sunday2) {
        this.sunday2 = sunday2;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }


}
