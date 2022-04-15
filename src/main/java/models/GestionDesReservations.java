package models;

import javafx.scene.layout.BorderPane;

import java.util.ArrayList;

public class GestionDesReservations {

    private static ArrayList<Reservation> reservationArrayList = new ArrayList<>();
    private static BorderPane pointeurRacine;

    //Liste de reservations
    public GestionDesReservations() {
        reservationArrayList.add(new Reservation("2022-06-01", "20:15", "Badminton"));
        reservationArrayList.add(new Reservation("2022-06-03", "12:45", "Musculation"));
        reservationArrayList.add(new Reservation("2022-06-04", "15:00", "Soccer"));
        reservationArrayList.add(new Reservation("2022-06-07", "15:00", "Tennis"));
    }

    public static void setPointeurRacine(BorderPane racine) {
        GestionDesReservations.pointeurRacine = racine;
    }

    public static ArrayList<Reservation> getReservationArrayList() {
        return reservationArrayList;
    }

    public ArrayList<Reservation> removeR(Reservation r1) {
        for (int i = 0; i < reservationArrayList.size(); i++) {
            if (r1.equals(reservationArrayList.get(i))) {
                reservationArrayList.remove(i);
            }
        }
        return reservationArrayList;
    }

    public ArrayList<Reservation> addR(Reservation r1) {
        reservationArrayList.add(r1);
        return reservationArrayList;
    }

}
