package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Reservation {
    private String activite;
    private LocalDate date;
    private String heure;
    private static ArrayList<Reservation>reservationArrayList = new ArrayList<>();

    public Reservation(String activite, LocalDate date, String heure) {
        this.activite = activite;
        this.date = date;
        this.heure = heure;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public static ArrayList<Reservation> getReservationArrayList() {
        return reservationArrayList;
    }

    public static void setReservationArrayList(ArrayList<Reservation> reservationArrayList) {
        Reservation.reservationArrayList = reservationArrayList;
    }
}
