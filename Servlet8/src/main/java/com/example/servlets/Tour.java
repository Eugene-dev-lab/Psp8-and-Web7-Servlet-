package com.example.servlets;

public class Tour {
    private int tour_id;
    private String firstname;
    private String lastname;
    private String startDate;
    private String endDate;
    private String destination;
    private String tourprice;

    public Tour() {

    }

    public Tour(int tour_id, String firstname, String lastname, String startDate, String endDate, String destination, String tourprice) {
        this.tour_id = tour_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.startDate = startDate;
        this.endDate = endDate;
        this.destination = destination;
        this.tourprice = tourprice;
    }

    public int getTour_id() {
        return tour_id;
    }

    public void setTour_id(int tour_id) {
        this.tour_id = tour_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTourprice() {
        return tourprice;
    }

    public void setTourprice(String tourprice) {
        this.tourprice = tourprice;
    }
}


