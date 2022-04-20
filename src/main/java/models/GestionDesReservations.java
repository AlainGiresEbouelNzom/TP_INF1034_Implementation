package models;

import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class GestionDesReservations {

    private static ArrayList<Reservation> reservationArrayList = new ArrayList<>();
    private static BorderPane acceuilBorderPane;
    private static Pane reservationPane;
    private static ChoiceBox choiceBoxActivite;
    private static int countId = 0;

    public static int getId() {
       return GestionDesReservations.countId++;
    }

    //Connexion avec la BorderPane de l'nterface Accueil
    public static void setAcceuilBorderPane(BorderPane acceuilBorderPane) {
        GestionDesReservations.acceuilBorderPane = acceuilBorderPane;
    }
    //Connexion avec la Pane Reservation, dans AccueilController
    public static void SetReservationPane(Pane reservationPane) {
        GestionDesReservations.reservationPane = reservationPane;
    }

    //Connexion avec la ChoiceBox de l'interface Reservation
    public static void connectWithChoiceBoxActivite(ChoiceBox choiceBoxActivite)
    {
        GestionDesReservations.choiceBoxActivite = choiceBoxActivite;
    }

    //Positionne l'interface Nouvelle Reservation
    public static void setReservationOnCenter(String activite){
        choiceBoxActivite.setValue(activite);
        acceuilBorderPane.setCenter(reservationPane);
    }

    //Liste de reservations
    public GestionDesReservations() {
        reservationArrayList.add(new Reservation("2022-06-01", "20:15", "Badminton"));
        reservationArrayList.add(new Reservation("2022-06-03", "12:45", "Musculation"));
        reservationArrayList.add(new Reservation("2022-06-04", "15:00", "Soccer"));
        reservationArrayList.add(new Reservation("2022-06-07", "15:00", "Tennis"));
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
