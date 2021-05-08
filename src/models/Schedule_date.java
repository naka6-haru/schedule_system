package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "schedule_dates")
@Entity
public class Schedule_date {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "schedule_start",nullable = false)
    private String schedule_start;

    @Column(name = "schedule_last",nullable = false)
    private String schedule_last;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchedule_start() {
        return schedule_start;
    }

    public void setSchedule_start(String schedule_start) {
        this.schedule_start = schedule_start;
    }

    public String getSchedule_last() {
        return schedule_last;
    }

    public void setSchedule_last(String schedule_last) {
        this.schedule_last = schedule_last;
    }

}
