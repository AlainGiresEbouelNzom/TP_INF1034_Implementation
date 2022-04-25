package models;

import java.io.Serializable;

public class Reservation implements Serializable {
    private String date;
    private String heure;
    private String nomActivite;

    public Reservation(String date, String heure, String nomActivite) {
        this.date = date;
        this.heure = heure;
        this.nomActivite= nomActivite;
    }

    public String getmin() {
        return heure.substring(3,5);
    }
    public String getheure() {
        return heure.substring(0,2);
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
                "    | " + " Activité = " + nomActivite;
    }
}
