package com.bs280.teami.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity(name = "attendees")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Attendee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendee_id;
    private String first_name;
    private String last_name;
    private String title;
    private String company;
    private String email;
    private Long phone_number;

    public Long getAttendee_id(){
        return attendee_id;
    }
    public void setAttendee_id(Long attendee_id){
        this.attendee_id = attendee_id;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(Long phone_number) {
        this.phone_number = phone_number;
    }
    
}
