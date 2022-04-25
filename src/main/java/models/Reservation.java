package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Reservation implements Serializable {

    private String date;
    private String heure;
    private String nomActivite;

    public Reservation(String date, String heure, String nomActivite) {
        this.date = date;
        this.heure = heure;
        this.nomActivite= nomActivite;
    }

    public int getmin() {
      
        String temp = String.valueOf(heure.charAt(3));
        temp += String.valueOf(heure.charAt(4));
        int min = Integer.parseInt(temp);
        return min;
    }

    public int getheure() {
        String temp = String.valueOf(heure.charAt(0));
        temp += String.valueOf(heure.charAt(1));
        int h = Integer.parseInt(temp);
        return h;
    }

    public String getDate() {
        return date;
    }

    public String getNomActivite() {
        return nomActivite;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public void setNomActivite(String nomActivite) {
        this.nomActivite = nomActivite;
    }

    @Override
    public String toString() {
        return  "Date = " + date +
                "    | Heure = " + heure +
                "h    | " + " Activité = " + nomActivite;
    }
}
