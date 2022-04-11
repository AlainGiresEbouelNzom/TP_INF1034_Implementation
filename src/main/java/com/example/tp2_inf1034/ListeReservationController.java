package com.example.tp2_inf1034;


import models.Reservation;

import java.util.ArrayList;

public class ListeReservationController{


    private static ArrayList<Reservation> listeControlerR = new ArrayList<>();

    //Exemple de donnes
    private void genererDonnees() {
        //Liste de reservations
        listeControlerR.add(new Reservation("2022-06-01", "20:15", "Badminton"));
        listeControlerR.add(new Reservation("2022-06-03", "12:45",  "Musculation"));
        listeControlerR.add(new Reservation("2022-06-04", "15:00",  "Soccer"));
        listeControlerR.add(new Reservation("2022-06-07", "15:00", "Tennis"));

    }
    public ArrayList<Reservation> getListeOfficielReservation(){
        genererDonnees();
        return listeControlerR;
    }

    public ArrayList<Reservation> removeR(Reservation r1){
        for(int i=0; i<listeControlerR.size(); i++){
            if(r1.equals(listeControlerR.get(i))){
                listeControlerR.remove(i);
            }
        }
        return listeControlerR;
    }

    public ArrayList<Reservation> addR(Reservation r1){
        listeControlerR.add(r1);
        return listeControlerR;
    }


}